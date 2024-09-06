package com.construclick.construclick.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.construclick.construclick.model.User;
import com.construclick.construclick.service.UserService;

@RestController
@RequestMapping("/registro/r1")
@CrossOrigin(origins="*" , methods = {RequestMethod.GET, RequestMethod.POST})

public class UserController {
private UserService userService;
	
	@Autowired
	public UserController(UserService userService) {
		this.userService = userService;
	}
	
	@GetMapping("/Construclick")
	public List<User> getMappingAll(){
		return  userService.getAll();
	}
	
	@PostMapping
	
	public User newUser(@RequestBody User user) {
		return userService.createUser(user);
	}
	
	@DeleteMapping("/Construclick/{id}")
	public void deleteUser(@PathVariable(name="id") Long id) {
		userService.deleteUser(id);
	}
	
	// Mapear método update User utilizando Put. Necesitamos acceder al user mediante Id (findById) y definir el nuevo valor
		@PutMapping("/Construclick/{id}/name")
		public User updateUserName(@RequestBody User user, @PathVariable(name = "id") Long id) {
			return userService.updateUserName(user, id);
		}
		
		@PutMapping("/Construclick/{id}/password")
		public User updateUserPassword(@RequestBody User user, @PathVariable(name = "id") Long id) {
			return userService.updateUserPassword(user, id);
		}
	
}
