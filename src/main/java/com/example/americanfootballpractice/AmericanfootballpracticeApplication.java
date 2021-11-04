package com.example.americanfootballpractice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.americanfootballpractice.domain.Participation;
import com.example.americanfootballpractice.domain.ParticipationRepository;
import com.example.americanfootballpractice.domain.Player;
import com.example.americanfootballpractice.domain.PlayerRepository;
import com.example.americanfootballpractice.domain.Position;
import com.example.americanfootballpractice.domain.PositionRepository;
import com.example.americanfootballpractice.domain.User;
import com.example.americanfootballpractice.domain.UserRepository;

import org.slf4j.LoggerFactory;

@SpringBootApplication
public class AmericanfootballpracticeApplication {

	private static final Logger log = LoggerFactory.getLogger(AmericanfootballpracticeApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(AmericanfootballpracticeApplication.class, args);
	}

	
	@Bean
	public CommandLineRunner playerDemo(PlayerRepository prepository, ParticipationRepository parepository, PositionRepository posrepository, UserRepository urepository) {
		return (args) -> {
			urepository.deleteAll();
			
			posrepository.save(new Position("Quarterback"));
			posrepository.save(new Position("OLine"));
			posrepository.save(new Position("DLine"));
			posrepository.save(new Position("Linebacker"));
			posrepository.save(new Position("DB"));
			posrepository.save(new Position("Receiver"));
			
			log.info("Save a few players");
			parepository.save(new Participation("Yes"));
			parepository.save(new Participation("No"));
			
		
			
			
		prepository.save(new Player("Max", "Bowen", 1999, posrepository.findByRole("OLine").get(0), parepository.findByAnswer("Yes").get(0)));
		prepository.save(new Player("Niko", "Bredbacka", 1996, posrepository.findByRole("Quarterback").get(0), parepository.findByAnswer("Yes").get(0)));
		prepository.save(new Player("Eetu", "Päiväniemi", 1994, posrepository.findByRole("Receiver").get(0), parepository.findByAnswer("No").get(0)));
		
		
		// Creating the user and admin credentials
		User user1 = new User("user", "$2a$06$3jYRJrg0ghaaypjZ/.g4SethoeA51ph3UD4kZi9oPkeMTpjKU5uo6", "USER");
		User user2 = new User("admin", "$2a$10$0MMwY.IQqpsVc1jC8u7IJ.2rT8b0Cd3b3sfIBGV2zfgnPGtT4r0.C", "ADMIN");
		urepository.save(user1);
		urepository.save(user2);
		
		};
	}
}
