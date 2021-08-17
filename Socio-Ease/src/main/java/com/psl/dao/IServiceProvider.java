package com.psl.dao;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.support.DaoSupport;
import org.springframework.data.repository.CrudRepository;
import com.psl.entities.*;


public interface IServiceProvider extends CrudRepository<ServiceProvider, Integer>{
	List<ServiceProvider> findByServiceCategory(Optional<ServiceCategory> optional);
}
