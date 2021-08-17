package com.psl.ServiceTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.psl.dao.IGuest;
import com.psl.entities.Guest;
import com.psl.entities.SocietyMember;
import com.psl.service.GuestService;

@SpringBootTest
public class GuestTest {
	@Autowired
	GuestService guestService;
	
	@Autowired
	IGuest dao;
	
	@ParameterizedTest
	@ValueSource(ints= {1})
	void addGuestTest(int guestId) {
		SocietyMember sc=new SocietyMember(1,12,"paul","paul@gmail.com","jgfsjd","656565",25,3,4,"dfhskfh");
		LocalDate ld=LocalDate.now();
		Guest guest=new Guest(guestId,"Nick","9587441122","nickblaine@gmail.com",5263,true,ld,sc);
		guestService.addGuest(guest);
		assertEquals(guest,dao.findById(1).get());
	}
	
	@ParameterizedTest
	@ValueSource(ints={1})
	void getGuestTest(int guestId) {
		Guest guest=guestService.getGuest(guestId);
		assertNotNull(guest);
	}
	
	@Test
	void showAllGuest() {
		Iterable<Guest> guestList=guestService.showAllGuest();
		for (Guest list:guestList) {
			System.out.println(list);
		}
		assertThat(guestList).size().isGreaterThan(0);
	}
	
	@ParameterizedTest
	@ValueSource(ints= {2})
	void deleteGuestTest(int guestId) {
		SocietyMember member=new SocietyMember(2,12,"paul","paul@gmail.com","jgfsjd","656565",25,3,4,"dfhskfh");
		dao.save(new Guest(2,"Ria","63546454","ria@gmail.com",5236,true,LocalDate.now(),member));
		Boolean presentBeforeDelete=dao.findById(guestId).isPresent();
		guestService.deleteGuest(guestId);
		Boolean notPresentAfterDelete=dao.findById(guestId).isPresent();
		assertTrue(presentBeforeDelete);
		assertFalse(notPresentAfterDelete);
	}
}
