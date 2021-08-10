package com.psl.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.psl.dao.IServiceCategory;
import com.psl.dao.IServiceProvider;
import com.psl.entities.ServiceCategory;
import com.psl.entities.ServiceProvider;

@Service("ServiceProvider")
public class ServiceProviderService {

//	@Autowired
//	private ServiceCategoryService service;
	@Autowired
	private IServiceProvider dao;
	@Autowired
	private IServiceCategory categoryDao;
	
	public ServiceProvider getServiceProvider(int providerId) {
		return dao.findById(providerId).get();
	}
	public Iterable<ServiceProvider> showServiceProvider(){
		System.out.println(dao.findAll());
		return dao.findAll();
	}
	
	public void addServiceProvider(ServiceProvider sp) {
		dao.save(sp);
	}
	public void deleteServiceProvider(int providerId) {
		dao.deleteById(providerId);
	}
	public void updateServiceProvider(ServiceProvider sp) {
		dao.save(sp);
	}
	public List<ServiceProvider> getAllByCategoryId(int categoryId) {
		//System.out.println("in ServiceProviderService == " + dao.findByCategoryId(categoryId) );
		return dao.findByServiceCategory(categoryDao.findById(categoryId));
	}
	
}
