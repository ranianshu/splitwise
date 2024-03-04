package com.scaler.splitwise;

import java.util.Optional;
import java.util.Scanner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.scaler.splitwise.commands.CommandRegistry;
import com.scaler.splitwise.exceptions.InvalidCommandException;
import com.scaler.splitwise.commands.Command;

@SpringBootApplication
public class SplitwiseApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(SplitwiseApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			System.out.println("Awaiting Input");
			String input = sc.nextLine();
			
			Optional<Command> optionalCommand = CommandRegistry.getInstance().get(input);
			if(optionalCommand.isEmpty()) {
				System.out.println("Please enter a valid command");
				continue;
			}
			
			Command command = optionalCommand.get();
			
			try {
				command.execute(input);
			}catch(InvalidCommandException e) {
				System.out.println("Error - " + e);
			}
		}
		
	}

}
