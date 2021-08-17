package com.psl.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import com.psl.entities.ServiceCategory;
import com.psl.entities.ServiceProvider;

public interface IServiceCategory extends CrudRepository<ServiceCategory, Integer>{
	//ServiceCategory findByCategoryName(String categoryName);
}
