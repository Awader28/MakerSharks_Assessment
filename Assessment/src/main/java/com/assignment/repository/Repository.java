package com.assignment.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.assignment.model.Model;



public interface Repository extends JpaRepository<Model, Integer> {
	List<Model> findUserByUsername(String username); /*finding user from their username
	 													as this method is user defined	*/
}
