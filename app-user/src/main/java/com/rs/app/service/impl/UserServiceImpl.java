package com.rs.app.service.impl;

import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.rs.app.bean.EmailJSON;
import com.rs.app.bean.MyBooks;
import com.rs.app.bean.Product;
import com.rs.app.bean.User;
import com.rs.app.config.KafkaService;
import com.rs.app.repositories.MyBooksRepository;
import com.rs.app.repositories.UserRepository;
import com.rs.app.request.AddMyBooksRequest;
import com.rs.app.request.GetMyBooksRequest;
import com.rs.app.request.GetUserIdRequest;
import com.rs.app.request.LoginRequest;
import com.rs.app.request.RegistrationRequest;
import com.rs.app.request.VerificationRequest;
import com.rs.app.service.UserService;
import com.rs.app.util.Constants;
import com.rs.app.util.DateUtil;
import com.rs.app.util.EmailJSONUtil;
import com.rs.app.util.LoggerUtil;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	private RestTemplate restTemplate;

	/*
	 * @Autowired private ConnectBookService connectBookService;
	 * 
	 * @Autowired private ConnectEmailService connectEmailService;
	 */

	@Autowired
	private MyBooksRepository myBooksRepository;

	@Autowired
	private KafkaService kafkaService;

	@Autowired
	private DateUtil dateUtil;

	public static User session;

	private static final Logger log = LoggerUtil.getLogger();

	private User setUser(RegistrationRequest request) {
		log.debug("UserServiceImpl:: setUser: " + request);
		User user = new User();

		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

		if (request != null) {
			user.setFirstName(request.getFirstName());
			user.setMiddleName(request.getMiddleName());
			user.setLastName(request.getLastName());
			user.setEmail(request.getEmail());
			user.setUsername(request.getUsername());

			String encodedPassword = passwordEncoder.encode(request.getPassword());
			user.setPassword(encodedPassword);

			user.setMobile(request.getMobile());
			user.setUserType(request.getUserType());

			user.setCreatedDate(dateUtil.currentDate());
			user.setEmailVerified("N");
		}
		return user;
	}

	private MyBooks setMyBooks(AddMyBooksRequest request) {
		MyBooks myBooks = new MyBooks();

		myBooks.setUId(request.getUId());
		Set<String> pIds = new LinkedHashSet<>();
		pIds.add(request.getPId());
		myBooks.setPIds(pIds);
		if (request.getId() != null) {
			myBooks.setId(request.getId());
		}
		return myBooks;
	}

	@Override
	public boolean registration(RegistrationRequest request) {
		log.debug("UserServiceImpl:: registration(): " + request);

		User user = setUser(request);
		boolean isRegistred = false;
		boolean isUsernameAvailable = userRepository.findByUsername(request.getUsername()) == null;
		if (isUsernameAvailable) {
			try {
				userRepository.save(user);
				isRegistred = true;
				EmailJSON details = EmailJSONUtil.setJSON(user);
				details.setType("welcome");
				kafkaService.emailContent(details);
				/*
				 * String emailStatus = connectEmailService.welcomeEmail(user.getEmail(),
				 * (user.getFirstName() + " " + user.getLastName()));
				 */
				// System.out.println(emailStatus);
				log.info("Email:: status: " + details);
			} catch (Exception e) {
				log.error("UserServiceImpl:: Registratio() Failed to save the user");
			}
		}
		return isRegistred;
	}

	@Override
	public User login(LoginRequest request) {
		log.debug("UserServiceImpl:: login(): " + request);
		User user = null;
		List<User> users = userRepository.findByUsernameAndUserType(request.getUsername(), request.getUserType());
		if (users != null && !users.isEmpty()) {
			user = users.get(0);
			session = user;
		}
		return user;
	}

	@Override
	public boolean verifyEmail(VerificationRequest request) {
		// ResponseEntity<String> response =
		// restTemplate.exchange(Constants.Verify_Email, HttpMethod.GET, null,
		// String.class);//connectEmailService.verificationEmail(request);
		String status = restTemplate.getForObject(Constants.Verify_Email, String.class);
		return (status.equalsIgnoreCase("Mail sent successfully")) ? true : false;
	}

	@Override
	public User getUser(GetUserIdRequest request) {
		log.info("UserServiceImpl:: getUser: " + request);

		Optional<User> oUser = userRepository.findById(request.getId());
		User user = oUser.get();
		if (user != null) {
			log.info("UserServiceImpl:: getUser(): user not null");
			GetMyBooksRequest request2 = new GetMyBooksRequest();
			request2.setUId(user.getId());
			List<Product> myBooks = getMyBooks(request2);
			if (myBooks != null && !myBooks.isEmpty()) {
				user.setProducts(myBooks);
			}
			Optional<List<MyBooks>> myBooksList = myBooksList(user.getId());
			if (myBooksList != null) {
				user.setPIds(myBooksList.get().get(0).getPIds());
			}
		} else {
			log.error("UserServiceImpl:: getUser() user is null");

		}
		return user;
	}

	@Override
	public boolean addMyBooks(AddMyBooksRequest request) {
		log.info("UserServiceImpl:: addMybooks(): " + request);
		GetMyBooksRequest uId = new GetMyBooksRequest();
		uId.setUId(request.getUId());
		MyBooks myBooks = setMyBooks(request);
		Optional<List<MyBooks>> myBooksList = myBooksList(request.getUId());
		if (myBooksList.get() != null && !myBooksList.get().isEmpty()) {
			Set<String> pIds = myBooksList.get().get(0).getPIds();
			pIds.add(request.getPId());
			if (request.getId() != null) {
				myBooks.setPIds(pIds);
			}
		} else {
			log.error("UserServiceImpl:: addMyBooks(): myBooksList is null");
		}

		try {

			myBooksRepository.save(myBooks);
			return true;
		} catch (Exception e) {
			log.error("UserServiceImpl:: addMyBooks(): Failed to save the book");
		}
		return false;
	}

	@Override
	public List<Product> getMyBooks(GetMyBooksRequest request) {
		log.info("UserServiceImpl:: getMybooks(): " + request);

		if (request == null || request.getUId() == null || request.getUId().isEmpty()) {
			log.error("UserServiceImpl:: addMyBooks(): request contains null in one ofthe required properties");
			return Collections.emptyList();
		}

		Optional<List<MyBooks>> myBooksList = myBooksList(request.getUId());
		List<Product> myBooks = new LinkedList<>();
		if (myBooksList.get() != null && !myBooksList.get().isEmpty()) {
			log.info("UserServiceImpl:: addMyBooks(): " + myBooksList);

			Set<String> pids = myBooksList.get().get(0).getPIds();
			if (myBooksList != null) {
				log.info("UserServiceImpl:: addMyBooks(): " + myBooksList);
				for (String pid : pids) {
					String url = Constants.GetProductById + pid;
					ResponseEntity<?> productResponse = restTemplate.exchange(url, HttpMethod.GET, null,
							ResponseEntity.class);// connectBookService.getProductById(pid);
					/*
					 * if (productResponse.getStatusCodeValue() ==
					 * HttpStatus.SERVICE_UNAVAILABLE.value()) { return null; }
					 */
					Product book = (Product) productResponse.getBody();
					if (book != null) {
						myBooks.add(book);
					}
				}
			}
		} else {
			log.error("UserServiceImpl:: addMyBooks(): myBooksList is null");
		}

		return myBooks != null ? myBooks : Collections.emptyList();
	}

	@Override
	public Optional<List<MyBooks>> myBooksList(String uId) {
		log.info("UserServiceImpl:: myBooksList(): " + uId);
		return myBooksRepository.findByuId(uId);
	}

}
