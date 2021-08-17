package com.psl.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.psl.entities.CommitteeMember;
import com.psl.entities.CommitteeMember;


public interface ICommitteeMember extends CrudRepository<CommitteeMember, Integer>{
	//List<CommiteMembers> findByName(String name);
}
