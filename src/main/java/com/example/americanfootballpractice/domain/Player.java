package com.example.americanfootballpractice.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Player {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String firstName;
	private String lastName;
	private int birthday;
	
	@ManyToOne
	@JoinColumn(name = "participationid")
	@JsonManagedReference
	private Participation participation;
	
	@ManyToOne
	@JoinColumn(name = "positionid")
	@JsonManagedReference
	private Position position;
	
	public Player() {}
	
	public Player(String firstName, String lastName, int birthday, Position position, Participation participation) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.birthday = birthday;
		this.position = position;
		this.participation = participation;
		
			
	}

	 public Long getId() {
		 return id;
	 }

	 public void setId(Long id) {
		 this.id = id;
	 }
	 
	 public String getFirstName() {
		 return firstName;
	 }
	 
	 public void setFirstName(String firstName) {
		 this.firstName = firstName;
	 }

	 public String getLastName() {
		 return lastName;
	 }
	 
	 public void setLastName(String lastName) {
		 this.lastName = lastName;
	 }
	 
	 public int getBirthday() {
		 return birthday;
	 }
	 
	 public void setBirthday(int birthday) {
		 this.birthday = birthday;
	 }
	 
	 
	 public Position getPosition() {
		return position;
	 }
	 
	 public void setPosition(Position position) {
		 this.position = position;
	 }
	 
	 public Participation getParticipation() {
		 return participation;
	 }
	 
	 public void setParticipation(Participation participation) {
		 this.participation = participation;
	 }
	 
	 @Override
	 public String toString() {
		 if (this.participation != null)
			 return "Player [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", birthday=" + birthday + "position=" + this.getPosition() + "participation=" + this.getParticipation() +  "]";	 
			 else		 
		 return "Player [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", birthday=" + birthday + "]";
	 }
}
