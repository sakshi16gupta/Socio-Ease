package com.psl.ServiceTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.psl.dao.IEventNotification;
import com.psl.entities.EventNotification;
import com.psl.service.EventNotificationService;


@SpringBootTest
public class EventNotificationTest {

	@Autowired
	private IEventNotification dao;
	
	@Autowired
	private EventNotificationService service;

	
	@ParameterizedTest
	@ValueSource(ints= {6})
	void addEventTest(int eventId){
		LocalDate ld=LocalDate.of(2021,11,05);
		EventNotification en=new EventNotification(eventId,"Diwali","Diwali celebration on 5 November, 2021",ld);
		service.addEvent(en);
		EventNotification event=dao.findById(eventId).get();
		assertEquals(en,event);
	}
	
	@Test
	void showAllEventTest() {
		Iterable<EventNotification> eventList= dao.findAll();
		for (EventNotification list:eventList) {
			System.out.println(list);
		}
		assertThat(eventList).size().isGreaterThan(0);
		}	
//	@ParameterizedTest
//	@ValueSource(ints= {7})
//	void updateEventTest(int eventId) {
//		LocalDate ld=LocalDate.of(2021,11,05);
//		EventNotification en=new EventNotification(eventId,"Diwali","Diwali celebration on 5 November, 2021",ld);
//		service.addEvent(en);
//		EventNotification event=dao.findById(eventId).get();
//		assertEquals(en,event);
//	}
	
	@ParameterizedTest
	@ValueSource(ints=15)
	void deleteEventsTest(int eventId) {
		Boolean isPresentBeforeDelete=dao.findById(eventId).isPresent();
		dao.deleteById(eventId);
		Boolean notPresentAfterDelete=dao.findById(eventId).isPresent();
		assertTrue(isPresentBeforeDelete);
		assertFalse(notPresentAfterDelete);
	}

	
}
