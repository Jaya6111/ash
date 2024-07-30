package com.rs.app.service.impl;

import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.rs.app.bean.EmailJSON;
import com.rs.app.bean.MyBooks;
import com.rs.app.bean.Product;
import com.rs.app.bean.User;
import com.rs.app.config.Constants;
import com.rs.app.feign.ConnectBookService;
import com.rs.app.feign.ConnectEmailService;
import com.rs.app.repositories.MyBooksRepository;
import com.rs.app.repositories.UserRepository;
import com.rs.app.request.AddMyBooksRequest;
import com.rs.app.request.GetMyBooksRequest;
import com.rs.app.request.GetUserIdRequest;
import com.rs.app.request.LoginRequest;
import com.rs.app.request.RegistrationRequest;
import com.rs.app.request.VerificationRequest;
import com.rs.app.service.UserService;
import com.rs.app.util.DateUtil;
import com.rs.app.util.EmailJSONUtil;
import com.rs.app.util.LoggerUtil;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepository;

	@Autowired
	ConnectBookService connectBookService;

	@Autowired
	private ConnectEmailService connectEmailService;

	@Autowired
	MyBooksRepository myBooksRepository;
	
	@Autowired
	private KafkaTemplate<String, Object> kafkaTemplate;

	@Autowired
	private DateUtil dateUtil;

	public static User session;

	private static final Logger logger = LoggerUtil.getLogger();

	private User setUser(RegistrationRequest request) {
		logger.debug("UserServiceImpl:: setUser: " + request);
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
		logger.debug("UserServiceImpl:: registration(): " + request);

		User user = setUser(request);
		boolean isRegistred = false;
		boolean isUsernameAvailable = userRepository.findByUsername(request.getUsername()) == null;
		if (isUsernameAvailable) {
			try {
				userRepository.save(user);
				isRegistred = true;
				EmailJSON details = EmailJSONUtil.setJSON(user);
				details.setType("welcome");
				kafkaTemplate.send(Constants.EMAIL,details);
				/*
				 * String emailStatus = connectEmailService.welcomeEmail(user.getEmail(),
				 * (user.getFirstName() + " " + user.getLastName()));
				 */
				//System.out.println(emailStatus);
				logger.info("Email:: status: " + details);
			} catch (Exception e) {
				logger.error("UserServiceImpl:: Registratio() Failed to save the user");
			}
		}
		return isRegistred;
	}

	@Override
	public User login(LoginRequest request) {
		logger.debug("UserServiceImpl:: login(): " + request);
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

		String status = connectEmailService.verificationEmail(request);
		return (status.equalsIgnoreCase("Mail sent successfully")) ? true : false;
	}

	@Override
	public User getUser(GetUserIdRequest request) {
		// logger.info("UserServiceImpl:: getUser: " + request);

		Optional<User> oUser = userRepository.findById(request.getId());
		User user = oUser.get();
		if (user != null) {
			// logger.info("UserServiceImpl:: getUser(): user not null");
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
			logger.error("UserServiceImpl:: getUser() user is null");

		}
		return user;
	}

	@Override
	public boolean addMyBooks(AddMyBooksRequest request) {
		logger.info("UserServiceImpl:: addMybooks(): " + request);
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
			logger.error("UserServiceImpl:: addMyBooks(): myBooksList is null");
		}

		try {

			myBooksRepository.save(myBooks);
			return true;
		} catch (Exception e) {
			logger.error("UserServiceImpl:: addMyBooks(): Failed to save the book");
		}
		return false;
	}

	@Override
	public List<Product> getMyBooks(GetMyBooksRequest request) {
		// logger.info("UserServiceImpl:: getMybooks(): " + request);

		if (request == null || request.getUId() == null || request.getUId().isEmpty()) {
			// logger.error("UserServiceImpl:: addMyBooks(): request contains null in one of
			// the required properties");
			return Collections.emptyList();
		}

		Optional<List<MyBooks>> myBooksList = myBooksList(request.getUId());
		List<Product> myBooks = new LinkedList<>();
		if (myBooksList.get() != null && !myBooksList.get().isEmpty()) {
			// logger.info("UserServiceImpl:: addMyBooks(): " + myBooksList);

			Set<String> pids = myBooksList.get().get(0).getPIds();
			if (myBooksList != null) {
				// logger.info("UserServiceImpl:: addMyBooks(): " + myBooksList);
				for (String pid : pids) {
					ResponseEntity<Product> productResponse = connectBookService.getProductById(pid);
					/*
					 * if (productResponse.getStatusCodeValue() ==
					 * HttpStatus.SERVICE_UNAVAILABLE.value()) { return null; }
					 */
					Product book = productResponse.getBody();
					if (book != null) {
						myBooks.add(book);
					}
				}
			}
		} else {
			// logger.error("UserServiceImpl:: addMyBooks(): myBooksList is null");
		}

		return myBooks != null ? myBooks : Collections.emptyList();
	}

	@Override
	public Optional<List<MyBooks>> myBooksList(String uId) {
		// logger.info("UserServiceImpl:: myBooksList(): " + uId);
		return myBooksRepository.findByuId(uId);
	}

}