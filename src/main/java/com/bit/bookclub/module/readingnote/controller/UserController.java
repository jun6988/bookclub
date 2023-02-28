package com.bit.bookclub.module.readingnote.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bit.bookclub.module.readingnote.entity.User;
import com.bit.bookclub.module.readingnote.repository.UserRepository;
import com.bit.bookclub.module.readingnote.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private UserRepository userRepository;
	
	@GetMapping("/list")
	public List<User> getAll() {
		
		System.out.println("user_count=" + userRepository.count());
		System.out.println("male_count=" + userRepository.countByGender("male"));
		
		return userService.getUserList();
	}
	
	@GetMapping("/list/{id}")
	public Optional<User> getUserById(@PathVariable("id") Integer id) {
		
		return userService.getUserListById(id);
	}
	
	@PostMapping("/regist")
	public User registUser(@RequestBody User user) {
		
		return userService.registUser(user);
	}
	
	@PutMapping("/update/{id}")
	public void updateUser(
			@PathVariable("id") Integer id,
			@RequestBody User user) {
		
		userService.updateUser(user);
	}
	
	@DeleteMapping("/delete/{id}")
	public void removeUser(@PathVariable Integer id) {
		
		userService.removeUser(id);
	}
	
//	@GetMapping("/test")
//	public void getAgeGraph() {
//		List<User> userList = new ArrayList<>();
//		
//		userService.ageGraph(userList);
//	}
	
}
