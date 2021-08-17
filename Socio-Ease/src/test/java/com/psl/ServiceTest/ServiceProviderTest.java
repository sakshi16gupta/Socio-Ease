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
import com.psl.dao.IServiceProvider;
import com.psl.entities.ServiceCategory;
import com.psl.entities.ServiceProvider;
import com.psl.service.ServiceProviderService;

@SpringBootTest
public class ServiceProviderTest {

	@Autowired
	private IServiceProvider dao;

	@Autowired
	private ServiceProviderService service;

	@ParameterizedTest
	@ValueSource(ints = { 2 })
	void addServiceProvider(int providerId) {

		ServiceCategory serviceCategory = new ServiceCategory(1, "d://documents", "Plumber");
		ServiceProvider sp = new ServiceProvider(providerId, "ElectricShop", 500, "951236",  "AdharCard","d://document",
				serviceCategory); 
		service.addServiceProvider(sp); 
		ServiceProvider servicep = dao.findById(providerId).get();
		assertEquals(sp, servicep);
	}

	@Test
	void showAllServiceProviderTest() {
		Iterable<ServiceProvider> serviceproviderList = dao.findAll();
		for (ServiceProvider list : serviceproviderList) {
			System.out.println(list);
		}
		assertThat(serviceproviderList).size().isGreaterThan(0);
	}

	@ParameterizedTest
	@ValueSource(ints = { 2 }) // we have to feed in db
	void deleteServiceProviderTest(int providerId) {
		Boolean isPresentBeforeDelete = dao.findById(providerId).isPresent();
		dao.deleteById(providerId);
		Boolean notPresentAfterDelete = dao.findById(providerId).isPresent();
		assertTrue(isPresentBeforeDelete);
		assertFalse(notPresentAfterDelete);
	}

	}
