
package com.psl.ServiceTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.psl.dao.IServiceCategory;
import com.psl.entities.ServiceCategory;
import com.psl.service.ServiceCategoryService;


@SpringBootTest
public class ServiceCategoryTest {

	@Autowired
	private IServiceCategory dao;
	
	@Autowired
	private ServiceCategoryService service;
	
	@ParameterizedTest
	@ValueSource(ints= {2})
	void addServiceCategoryTest(int categoryId){
		
		ServiceCategory sc=new ServiceCategory(categoryId,"d://documents","Electrician");    //isme data daalna hai
		service.addCategory(sc);
		ServiceCategory event=dao.findById(categoryId).get();
		assertEquals(sc,event);
	}
	
	@Test
	void showAllServiceCategoryTest() {
		Iterable<ServiceCategory> categoryList= dao.findAll();
		for (ServiceCategory list:categoryList) {
			System.out.println(list);
		}
		assertThat(categoryList).size().isGreaterThan(0);
		}	

	
	@ParameterizedTest
	@ValueSource(ints=2)    //isme data db me daalna hai
	void deleteServiceCategoryTest(int categoryId) {
		Boolean isPresentBeforeDelete=dao.findById(categoryId).isPresent();
		dao.deleteById(categoryId);
		Boolean notPresentAfterDelete=dao.findById(categoryId).isPresent();
		assertTrue(isPresentBeforeDelete);
		assertFalse(notPresentAfterDelete);
	}
	
}
