package com.example.americanfootballpractice.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.americanfootballpractice.domain.ParticipationRepository;
import com.example.americanfootballpractice.domain.Player;
import com.example.americanfootballpractice.domain.PlayerRepository;
import com.example.americanfootballpractice.domain.PositionRepository;

@Controller
public class PracticeController {

	@Autowired
	private PlayerRepository repository;
	
	@Autowired
	private ParticipationRepository parepository;
	
	@Autowired
	private PositionRepository posrepository;
	
	// Login page
	@RequestMapping(value= "/login")
	public String login() {
		return "login";
	}
	
	
	//Page for playerslist
	@RequestMapping(value = {"/", "playerlist"})
	public String playerList(Model model) {
		model.addAttribute("players", repository.findAll());
		return "playerlist";
	}
	// REST service to find all players
	@RequestMapping(value="players", method = RequestMethod.GET)
	public @ResponseBody List<Player> playerListRest() {
		return (List<Player>) repository.findAll();
	}
	
	
	// REST service to find players by Id
	@RequestMapping(value="/player/{id}", method = RequestMethod.GET)
	public @ResponseBody Optional<Player> findPlayerRest(@PathVariable("id") Long playerId) {
		return repository.findById(playerId);
	}
	
	
	// Adding a new player
	@RequestMapping(value = "/add")
	public String addPlayer(Model model) {
		model.addAttribute("player", new Player());
		model.addAttribute("participations", parepository.findAll());
		model.addAttribute("positions", posrepository.findAll());
		return "addplayer";
	}
	
	// Save a new player into the Repo
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(Player player) {
		repository.save(player);
		return "redirect:playerlist";
	}
	
	// Editing an existing player
	@RequestMapping(value = "/edit/{id}")
	public String editPlayer(@PathVariable("id")Long playerId, Model model) {
		model.addAttribute("player", repository.findById(playerId));
		model.addAttribute("participations", parepository.findAll());
		model.addAttribute("positions", posrepository.findAll());
		return "editplayer";
	}
	
	
	// Delete a player
	@PreAuthorize("hasAuthority('ADMIN')")
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public String deletePlayer(@PathVariable("id") Long playerId, Model model) {
		repository.deleteById(playerId);
		return "redirect:../playerlist";
	}
}

