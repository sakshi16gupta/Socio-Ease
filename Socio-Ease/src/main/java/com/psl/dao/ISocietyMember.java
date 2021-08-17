package com.psl.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.psl.entities.SocietyMember;

public interface ISocietyMember extends CrudRepository<SocietyMember, Integer>{
	SocietyMember findByEmail(String email);
}
