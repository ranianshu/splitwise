package com.scaler.splitwise.services;

import com.scaler.splitwise.exception.UserAlreadyExistException;
import com.scaler.splitwise.models.User;

public interface UserService {
	
	public User registerUser(String userName, String password, String phoneNumber) throws UserAlreadyExistException;
	

}
