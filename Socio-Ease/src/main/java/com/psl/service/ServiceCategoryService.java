package com.psl.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.psl.dao.IServiceCategory;
import com.psl.entities.ServiceCategory;

@Service("serviceCategory")
public class ServiceCategoryService {

	@Autowired
	private IServiceCategory dao;
	
	public ServiceCategory getServiceCategory(int categoryId){
		return dao.findById(categoryId).get();
	}
	public Iterable<ServiceCategory> showServiceCategory(){
		return dao.findAll();
	}
	public void addCategory(ServiceCategory sc) {
		dao.save(sc);
	}
	public void updateCategory(ServiceCategory sc) {
		dao.save(sc);
	}
	public void deleteCategory(int categoryId) {
		dao.deleteById(categoryId);
	}
//	public int findByCategoryName(String categoryName) {
//		System.out.println("in ServiceCategoryService == "+categoryName);
//		System.out.println(dao.findByCategoryName(categoryName));
//		return 1;
//	}
	
	
}
