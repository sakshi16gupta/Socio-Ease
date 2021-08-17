package com.psl.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.psl.dao.IEventNotification;
import com.psl.entities.EventNotification;

@Service("EventNotificationService")
public class EventNotificationService {
	
	@Autowired
	private IEventNotification dao;

	public EventNotification getEvent(int eventId) {
		return dao.findById(eventId).get();
	}
	public void addEvent(EventNotification en) {
		dao.save(en);
	}
	public void updateEvent(EventNotification en) {
		dao.save(en);
	}
	public Iterable<EventNotification> showAllEvent() {
		return dao.findAll();
	}
	public void deleteEvents(int eventId) {
		dao.deleteById(eventId);
	}
	
}
