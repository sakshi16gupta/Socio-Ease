package com.psl.dao;

import org.springframework.data.repository.CrudRepository;

import com.psl.entities.EventNotification;

public interface IEventNotification extends CrudRepository<EventNotification, Integer> {

}
