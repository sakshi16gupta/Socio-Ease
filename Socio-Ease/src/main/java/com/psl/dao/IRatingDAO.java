package com.psl.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import com.psl.entities.Rating;
import com.psl.entities.ServiceProvider;

public interface IRatingDAO extends CrudRepository<Rating, Integer>{
	List<Rating> findByServiceProvider(ServiceProvider serviceProvider);
}

