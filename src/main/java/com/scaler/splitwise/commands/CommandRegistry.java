package com.scaler.splitwise.commands;

import java.util.Map;
import java.util.Optional;
import java.util.HashMap;

public class CommandRegistry {
	
	private Map<String, Command> map;
	
	private CommandRegistry() {
		map = new HashMap<>();
	}
	
	private static CommandRegistry INSTANCE = new CommandRegistry();
	
	public static CommandRegistry getInstance() {
		return INSTANCE;
	}
	
	public void register(String key, Command command) {
		map.put(key, command);	
	}
	
	public Optional<Command> get(String input) {
		String [] splits = input.split(" ");
		for(String split: splits) {
			if(map.containsKey(split)) {
				return Optional.of(map.get(split));
			}
		}
		return Optional.empty();
	}

}
