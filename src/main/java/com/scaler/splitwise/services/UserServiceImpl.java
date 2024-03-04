package com.scaler.splitwise.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.scaler.splitwise.exception.UserAlreadyExistException;
import com.scaler.splitwise.models.User;
import com.scaler.splitwise.repositories.UserRepository;

@Service
public class UserServiceImpl implements UserService{
	
	private UserRepository userRepository;
	
	@Autowired
	public UserServiceImpl(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	public User registerUser(String userName, String password, String phoneNumber) throws UserAlreadyExistException {
		
		Optional<User> optionalUser = userRepository.findByUserName(userName);
		if(optionalUser.isPresent()) {
			throw new UserAlreadyExistException("User already exists");
		}
		BCryptPasswordEncoder bcrypt = new BCryptPasswordEncoder();
		String encodedPassword = bcrypt.encode(password);
		User user = new User();
		user.setUserName(userName);
		user.setPassword(encodedPassword);
		user.setPhoneNumber(phoneNumber);
		
		User savedUser = userRepository.save(user);
		return savedUser;
	}

}
