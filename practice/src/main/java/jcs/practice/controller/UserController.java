package jcs.practice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jcs.practice.entity.User;
import jcs.practice.service.DemoService;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private DemoService demoService;

	@GetMapping("/getUser/{id}")
	public User getUser(@PathVariable int id) {

		return demoService.getUser(id);
	}

	@PutMapping("/saveUser")
	public User saveUser(@RequestBody User user) {

		return demoService.saveUser(user);
	}

	@DeleteMapping("/deleteUser/{id}")
	public String deleteUser(@PathVariable int id) {
		boolean delete = demoService.deleteUser(id);
		if (delete) {
			return "User deleted with ID : " + id + " Successfully";
		}
		return "User not found in the Data base with ID : " + id;
	}
	
	@GetMapping("/getAll")
	public List<User> getAllUsers(){
		return demoService.getAllUsers();
	}

}
