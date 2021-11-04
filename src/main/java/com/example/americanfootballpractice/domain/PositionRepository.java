package com.example.americanfootballpractice.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface PositionRepository extends CrudRepository<Position, Long> {

	List<Position> findByRole(String role);
}
