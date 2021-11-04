package com.example.americanfootballpractice.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface ParticipationRepository extends CrudRepository<Participation, Long> {

	List<Participation> findByAnswer (String answer);
}
