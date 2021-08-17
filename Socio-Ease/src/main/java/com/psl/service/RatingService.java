package com.psl.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.psl.dao.IRatingDAO;
import com.psl.entities.Rating;
import com.psl.entities.ServiceProvider;

@Service("ratingService")
public class RatingService {

	@Autowired
	private IRatingDAO dao;
	
	@Autowired
	private ServiceProviderService service;
	
	public Rating getRating(int ratingId) {		
		return dao.findById(ratingId).get();
	}	
	public Iterable<Rating> showRating() {
		return dao.findAll();
	}
	public void addRating(Rating r) {
		dao.save(r);
	}	
	public void deleteRating(int ratingId){
		dao.deleteById(ratingId);
	}	
	public void updateRating(Rating r) {
		dao.save(r);
	}
	public List<Rating> getAllByServiceProvider(int id) {
		//System.out.println("in ServiceProviderService == " + dao.findByCategoryId(categoryId) );
		return dao.findByServiceProvider(service.getServiceProvider(id));
	}
	
}
