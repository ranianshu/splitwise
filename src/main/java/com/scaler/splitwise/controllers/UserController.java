package com.scaler.splitwise.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.scaler.splitwise.dtos.RegisterUserRequestDto;
import com.scaler.splitwise.dtos.RegisterUserResponseDto;
import com.scaler.splitwise.dtos.ResponseStatus;
import com.scaler.splitwise.exception.UserAlreadyExistException;
import com.scaler.splitwise.models.User;
import com.scaler.splitwise.services.UserService;

@Controller
public class UserController {
	
	private UserService userService;
	
	@Autowired
	public UserController(UserService userService) {
		this.userService = userService;
	}
	
	public RegisterUserResponseDto registerUser(RegisterUserRequestDto request) {
		RegisterUserResponseDto responseDto = new RegisterUserResponseDto();
		try {
			User user = userService.registerUser(request.getUsername(), request.getPassword(), request.getPhoneNumber());
			responseDto.setId(user.getId());
			responseDto.setUsername(user.getUserName());
			responseDto.setPhoneNumber(user.getPhoneNumber());
			responseDto.setResponseStatus(ResponseStatus.SUCCESS);
		} catch (UserAlreadyExistException e) {
			responseDto.setErrorMessage(e.getMessage());
			responseDto.setResponseStatus(ResponseStatus.FAILURE);
		}catch(Exception e) {
			responseDto.setErrorMessage(e.getMessage());
			responseDto.setResponseStatus(ResponseStatus.FAILURE);
		}
		return responseDto;
		
	}

}
