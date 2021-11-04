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
public class Position {

	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long positionid;
	private String role;
	
	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL, mappedBy= "position")
	private List<Player> players;
	
	public Position() {}
	
	public Position(String role) {
		super();
		this.role= role;
	}
	
	public Long getPositionid() {
		return positionid;
	}
	public void setPositionid(Long positionid) {
		this.positionid = positionid;
	}
	
	public String getRole() {
		return role;
	}
	
	public void setRole(String role) {
		this.role = role;
	}
	
	public List<Player> getPlayers(){
		return players;
	}
	
	public void setPlayers(List<Player> players) {
		this.players = players;
	}
	
	@Override
	public String toString() {
		return "Position [positionid=" + positionid + ",role=" + role + "]";
				
	}
	
	
	
	
}
