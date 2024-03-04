package com.scaler.splitwise.commands;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.scaler.splitwise.controllers.UserController;
import com.scaler.splitwise.dtos.RegisterUserRequestDto;
import com.scaler.splitwise.dtos.RegisterUserResponseDto;
import com.scaler.splitwise.dtos.ResponseStatus;
import com.scaler.splitwise.exceptions.InvalidCommandException;

@Component
public class RegisterUserCommand implements Command{
	
	private static final String REGISTER_USER_COMMAND = "Register";
	private UserController userController;

	@Autowired
	public RegisterUserCommand(UserController userController) {
		CommandRegistry.getInstance().register(REGISTER_USER_COMMAND, this);
		this.userController = userController;
	}

	@Override
	public void execute(String input) throws InvalidCommandException {
		
		if(input == null || input.length() == 0) {
			throw new InvalidCommandException("Register User Command cannot be null");
		}
		String [] splits = input.split(" ");
		
		if(splits.length != 4) {
			throw new InvalidCommandException("Register User Command length is less than 4");
		}
		
		if(!splits[0].equals(REGISTER_USER_COMMAND)) {
			throw new InvalidCommandException("Register User Command is not in expected format");
		}	
		
		RegisterUserRequestDto registerUserRequestDto = new RegisterUserRequestDto();
		registerUserRequestDto.setUsername(splits[1]);
		registerUserRequestDto.setPhoneNumber(splits[2]);
		registerUserRequestDto.setPassword(splits[3]);
		
		//call the registerUser method of UserController
		RegisterUserResponseDto registerUserResponseDto = userController.registerUser(registerUserRequestDto);
		if(registerUserResponseDto.getResponseStatus().equals(ResponseStatus.FAILURE)) {
			System.out.println("Error: " + registerUserResponseDto.getErrorMessage());
		}else {
			System.out.println("UserId: " + registerUserResponseDto.getId());
		}
	}

}
