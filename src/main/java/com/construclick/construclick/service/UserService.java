package com.construclick.construclick.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.construclick.construclick.exceptions.UserNotFoundException;
import com.construclick.construclick.model.User;
import com.construclick.construclick.repository.UserRepository;

@Service
public class UserService {
private UserRepository userRepository;

@Autowired
public UserService(UserRepository userRepository) {
	super();
	this.userRepository = userRepository;
}

public List<User> getAll(){
	return userRepository.findAll();
}

public User createUser(User newUser) {
	return userRepository.save(newUser);
}

public void deleteUser(Long id) {
	if(userRepository.existsById(id)) {
		userRepository.deleteById(id);
	}else {
		throw new UserNotFoundException(id);
	}
}

public User updateUserPassword(User user, Long id) {
	return userRepository.findById(id)
			.map(userMap -> {
				userMap.setPassword(user.getPassword());
				return userRepository.save(userMap);
			})
			.orElseThrow(() -> new UserNotFoundException(id));
}

public User updateUserName(User user, Long id) {
	return userRepository.findById(id)
			.map(userMap -> {
				userMap.setUsername(user.getUsername());
				return userRepository.save(userMap);
			})
			.orElseThrow(() -> new UserNotFoundException(id));
}

}
