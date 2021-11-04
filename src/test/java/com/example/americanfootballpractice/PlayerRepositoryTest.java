package com.example.americanfootballpractice;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.example.americanfootballpractice.domain.Participation;
import com.example.americanfootballpractice.domain.ParticipationRepository;
import com.example.americanfootballpractice.domain.Player;
import com.example.americanfootballpractice.domain.PlayerRepository;
import com.example.americanfootballpractice.domain.Position;
import com.example.americanfootballpractice.domain.PositionRepository;



// Tests the repository functionality. 
// Finds a player from the repo by using their last name 

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class PlayerRepositoryTest {
	
	
	@Autowired
	private PlayerRepository repository;
	
	@Test public void findByLastNameShouldReturnPlayer() {
		List <Player> players = repository.findByLastName("Bowen");
		
		assertThat(players).hasSize(1);
		assertThat(players.get(0).getFirstName()).isEqualTo("Max");
		
	}
	

}
