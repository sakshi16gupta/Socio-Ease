package com.psl.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.psl.entities.User;

public interface IUserDao extends CrudRepository<User, Long> {

	@Query("SELECT u from User u Where u.username = :username")
	public User getUserByUsername(@Param("username") String username);
	
}
