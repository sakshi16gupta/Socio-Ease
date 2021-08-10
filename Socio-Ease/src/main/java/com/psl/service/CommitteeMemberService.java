package com.psl.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.psl.dao.ICommitteeMember;
import com.psl.entities.CommitteeMember;
import com.psl.entities.Rating;
import com.psl.entities.CommitteeMember;

@Service("CommitteeMemberService")
public class CommitteeMemberService {
		
		@Autowired
		private ICommitteeMember dao;
		
		public void addCommitteeMember (CommitteeMember e) {
			dao.save(e);
		}
		public CommitteeMember getCommiteeMember (int id) {
			return dao.findById(id).get();
		}
		
		public void updateCommitteeMember (CommitteeMember e) {
			dao.save(e);
		}
		
		public void deleteCommitteeMember (int id) {
			dao.deleteById(id);
		}
		
		public Iterable<CommitteeMember> showCommitteeMembers() {
			return dao.findAll();
		}
		
//		public List<CommiteMembers> searchByName(String name) {
//			return dao.findByName(name);
//		}

}
