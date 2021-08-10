package com.psl.dao;

import org.springframework.data.repository.CrudRepository;
import com.psl.entities.Rating;

public interface IRatingDAO extends CrudRepository<Rating, Integer>{

}

