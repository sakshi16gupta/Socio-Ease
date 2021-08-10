package com.psl.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.psl.entities.Guest;
import com.psl.entities.SocietyMember;

public interface IGuest extends CrudRepository<Guest, Integer>{
	List<Guest> findBySocietyMember(Optional<SocietyMember> optional);
}
