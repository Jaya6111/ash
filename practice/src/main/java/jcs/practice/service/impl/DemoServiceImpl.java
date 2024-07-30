package jcs.practice.service.impl;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.zip.Deflater;
import java.util.zip.Inflater;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import jcs.practice.entity.Been;
import jcs.practice.entity.ImageData;
import jcs.practice.entity.User;
import jcs.practice.repository.DemoRepository;
import jcs.practice.repository.FileRepository;
import jcs.practice.repository.UserRepository;
import jcs.practice.service.DemoService;

@Service
public class DemoServiceImpl implements DemoService {

	@Autowired
	DemoRepository demoRepository;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private FileRepository repository;

	User user;
	Optional<Been> o;

	private Been getBeen(String s) {
		Been b = new Been();
		b.setMessage(s);
		return b;
	}

	public static byte[] compressImage(byte[] data) {
		Deflater deflater = new Deflater();
		deflater.setLevel(Deflater.BEST_COMPRESSION);
		deflater.setInput(data);
		deflater.finish();

		ByteArrayOutputStream outputStream = new ByteArrayOutputStream(data.length);
		byte[] tmp = new byte[4 * 1024];
		while (!deflater.finished()) {
			int size = deflater.deflate(tmp);
			outputStream.write(tmp, 0, size);
		}
		try {
			outputStream.close();
		} catch (Exception ignored) {
		}
		return outputStream.toByteArray();
	}

	public static byte[] decompressImage(byte[] data) {
		Inflater inflater = new Inflater();
		inflater.setInput(data);
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream(data.length);
		byte[] tmp = new byte[4 * 1024];
		try {
			while (!inflater.finished()) {
				int count = inflater.inflate(tmp);
				outputStream.write(tmp, 0, count);
			}
			outputStream.close();
		} catch (Exception ignored) {
		}
		return outputStream.toByteArray();
	}

	public String getString(int id) {

		o = demoRepository.findById(id);
		return o.get().getMessage();
	}

	public String saveString(String s) {

		Been b = new Been();
		b = getBeen(s);
		try {
			demoRepository.save(b);
		} catch (Exception e) {
			return " Failed to save";
		}
		return "Message saved";
	}

	public String updateString(int id, String s) {

		Been b = new Been();
		b = getBeen(s);
		b.setId(id);

		try {
			demoRepository.save(b);
		} catch (Exception e) {
			return " Failed to update";
		}
		return "Message Updated";
	}

	public String deleteString(int id) {

		try {
			demoRepository.deleteById(id);
		} catch (Exception e) {
			return " Failed to Delete";
		}
		return "Deleted";
	}

	@Override
	public User getUser(int id) {

		user = new User();
		Optional<User> o = userRepository.findById(id);
		if (o.isPresent()) {
			return o.get();
		}

		return user;
	}

	@Override
	public User saveUser(User user) {

		User u = userRepository.save(user);
		return u;
	}

	@Override
	public boolean deleteUser(int id) {

		try {
			userRepository.deleteById(id);
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	public String uploadImage(MultipartFile file, String name) throws IOException {

		ImageData imageData = repository.save(ImageData.builder().name(file.getOriginalFilename())
				.type(file.getContentType()).imageData(compressImage(file.getBytes())).build());
		if (imageData != null) {
			return "file uploaded successfully : " + file.getOriginalFilename();
		}
		return null;
	}

	public byte[] downloadImage(String fileName) {
		Optional<ImageData> dbImageData = repository.findByName(fileName);
		byte[] images = decompressImage(dbImageData.get().getImageData());
		return images;
	}

	@Override
	public List<User> getAllUsers() {
		// TODO Auto-generated method stub
		return userRepository.findAll();
	}
}
