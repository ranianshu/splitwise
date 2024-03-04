package com.scaler.splitwise.commands;

import com.scaler.splitwise.exceptions.InvalidCommandException;

public interface Command {
	
	public void execute(String input) throws InvalidCommandException;

}
