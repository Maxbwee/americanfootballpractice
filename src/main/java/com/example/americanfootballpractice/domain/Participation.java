package com.example.americanfootballpractice.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Participation {

	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long participationid;
	private String answer;
	
	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL, mappedBy= "participation")
	private List<Player> players;
	
	
	public Participation() {}
	
	public Participation(String answer) {
		super();
		this.answer = answer;
	}
	
	public Long getParticipationid() {
		return participationid;
	}
	
	public void setParticipationid(Long participationid) {
		
		this.participationid = participationid;
	}
	
	public String getAnswer() {
		return answer;
	}
	
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	
	public List<Player> getPlayers(){
		return players;
	}
	
	public void setPlayers(List<Player> players) {
		this.players = players;
	}
	
	@Override
	public String toString() {
		return "Participation [participationid=" + participationid + ", answer=" + answer + "]";
	}
	
}
