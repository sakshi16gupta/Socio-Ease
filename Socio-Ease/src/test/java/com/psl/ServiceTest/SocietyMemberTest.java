package com.psl.ServiceTest;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.util.stream.Stream;

import javax.validation.constraints.AssertTrue;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import com.psl.dao.ISocietyMember;
import com.psl.entities.SocietyMember;
import com.psl.service.SocietyMemberService;

@SpringBootTest
public class SocietyMemberTest {

	@Autowired
	private SocietyMemberService societyMemberService;
	
	@Autowired
	private ISocietyMember dao;

	@Test
	void addSocietymemberTest() {
		int memberId=2;
		SocietyMember societyMember=new SocietyMember(memberId,2,"jack","jack@gmail.com","password",958933,1,4,3,"d://documents/");
		societyMemberService.addSocietyMember(societyMember);
		SocietyMember member=dao.findById(societyMember.getMemberId()).get();
		assertEquals(societyMember,member);
	}
	
	@ParameterizedTest
	@ValueSource(ints= {1})
	void getSocietyMemberTest(int memberId) {
		SocietyMember member=societyMemberService.getSocietyMember(memberId);
		assertNotNull(member);
	}
	
	@ParameterizedTest
	@ValueSource(ints= {3})
	void updateSocietyMemberTest(int memberId) {
		SocietyMember memberBeforeUpdate=dao.findById(memberId).get();
		SocietyMember societyMember=new SocietyMember(memberId,2,"paul","paul12@gmail.com","password",958933,1,4,3,"d://documents/");
		societyMemberService.updateSocietyMember(societyMember);
		SocietyMember memberAfterUpdate=dao.findById(memberId).get();
		assertNotEquals(memberBeforeUpdate,memberAfterUpdate);
	}
	
	@ParameterizedTest
	@ValueSource(ints= {2})
	void deleteSocietyMemberTest(int memberId) {
		Boolean presentBeforeDelete=dao.findById(memberId).isPresent();
		societyMemberService.deleteSocietyMember(memberId);
		Boolean notPresentAfterDelete=dao.findById(memberId).isPresent();
		assertTrue(presentBeforeDelete);
		assertFalse(notPresentAfterDelete);
	}	
	
	@ParameterizedTest
	@ValueSource(strings = {"max123456@gmail.com"})
	void findByEmailTest(String email) {
		SocietyMember member=societyMemberService.findByEmail(email);
		assertNotNull(member);
	} 
	
	
	@Test
	void checkMemberTest() {
		String email="max123456@gmail.com";
		String password="password";
		//System.out.println("email: " + email + " ==== password : " + password);
		System.out.println((dao.findByEmail(email)!=null)+" in service checking email");
		if(dao.findByEmail(email)!=null) {
			System.out.println(dao.findByEmail(email).getPassword().equals(password)+" in service checking passowrd");
			String a=dao.findByEmail(email).getPassword();
			assertEquals(a,password);
			

		}
	}
	
}