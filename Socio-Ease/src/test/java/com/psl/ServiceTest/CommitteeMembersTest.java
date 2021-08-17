package com.psl.ServiceTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.psl.dao.ICommitteeMember;
import com.psl.entities.CommitteeMember;
import com.psl.service.CommitteeMemberService;

@SpringBootTest
public class CommitteeMembersTest {

	@Autowired
	private CommitteeMemberService committeeMemberService;
	
	@Autowired
	private ICommitteeMember dao;
	
	@ParameterizedTest
	@ValueSource(ints= {1,2})
	void addCommitteeMemberTest(int memberId) {
		CommitteeMember memberObject= new CommitteeMember(memberId,"Ajay Sharma","95425555","Secretory","D:\\documents");
		committeeMemberService.addCommitteeMember(memberObject);
		CommitteeMember member=dao.findById(memberId).get();
		assertEquals(member,memberObject);
	}
	
	@Test
	void getCommitteeMemberTest() {
		CommitteeMember member=committeeMemberService.getCommiteeMember(2);
		assertNotNull(member);
	}
	
	@Test
	void showCommitteeMembersTest() {
		Iterable<CommitteeMember> memberlist=committeeMemberService.showCommitteeMembers();
		for (CommitteeMember list:memberlist) {
			System.out.println(list);
		}
		assertThat(memberlist).size().isGreaterThan(0);
	}
	
	@ParameterizedTest
	@ValueSource(ints= {1})
	void deleteCommitteeMembers(int memberId) {
		Boolean presentBeforeDelete=dao.findById(memberId).isPresent();
		committeeMemberService.deleteCommitteeMember(memberId);
		Boolean notPresentAfterDelete=dao.findById(memberId).isPresent();
		assertTrue(presentBeforeDelete);
		assertFalse(notPresentAfterDelete);
	}
	
	
}























