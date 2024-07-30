package jcs.practice.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import jcs.practice.entity.User;
import jcs.practice.repository.UserRepository;
import jcs.practice.service.DemoService;
import jcs.practice.service.impl.DemoServiceImpl;

@Controller
@RequestMapping("/demo")
public class DemoController {

	@Autowired
	DemoService demoService;

	@Autowired
	DemoServiceImpl service;
	
	@Autowired
	private UserRepository repo;

	@GetMapping("/get/{id}")
	public String getDemo(@PathVariable int id) {

		return demoService.getString(id);
	}

	@PutMapping("/put/{s}")
	public String putDemo(@PathVariable String s) {

		return demoService.saveString(s);
	}

	@PostMapping("/post/{id}/{s}")
	public String postDemo(@PathVariable int id, @PathVariable String s) {

		return demoService.updateString(id, s);
	}

	@DeleteMapping("/delete/{id}")
	public String deleteDemo(@PathVariable int id) {
		return demoService.deleteString(id);
	}

	@PostMapping
	public ResponseEntity<?> uploadImage(@RequestParam("image") MultipartFile file, @RequestParam String name) throws IOException {
		String uploadImage = service.uploadImage(file, name);
		return ResponseEntity.status(HttpStatus.OK).body(uploadImage);
	}

	@GetMapping("/{fileName}")
	public ResponseEntity<?> displayFile(@PathVariable String fileName) {
		try {
			byte[] imageData = service.downloadImage(fileName);
			return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_PDF)
					.header(HttpHeaders.CONTENT_DISPOSITION, "inline; filename=\"" + fileName + "\"").body(imageData);
		} catch (RuntimeException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("File not found with name " + fileName);
		}
	}
	
	@RequestMapping(value = "/html", method = RequestMethod.GET, produces = MediaType.APPLICATION_XHTML_XML_VALUE)
	public String html(){
		return "Success";
	} 
	
	 @GetMapping("/limit")
	    public List<User> limitUsers(@RequestParam String place, @RequestParam int num) {
	        Pageable pageable = PageRequest.of(0, num);
	        return repo.findByPlaceWithLimit(place, pageable);
	    }

}
