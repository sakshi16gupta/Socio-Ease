package com.psl.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.psl.entities.Rating;
import com.psl.entities.ServiceProvider;
import com.psl.service.RatingService;
import com.psl.service.ServiceCategoryService;
import com.psl.service.ServiceProviderService;

@Controller
public class RatingController {
	@Value("${spring.application.name}")
    String appName;
	
	@Autowired
	ServiceProviderService serviceProviderService;
	@Autowired
	RatingService service;
	
	
	@GetMapping("/addrating/{id}")
	public String addRating(Model model, @PathVariable int id) {
		//System.out.println(categoryId);
		model.addAttribute("appName", appName);
		model.addAttribute("rating", new Rating());
		model.addAttribute("id",id);
//		model.addAttribute("helpers", serviceProviderService.getAllByCategoryId(categoryId));
		return "addrating";
	}
	
	@GetMapping("/rating/{id}")
	public String viewRating(Model model, @PathVariable int id) {
		model.addAttribute("appName", appName);
		List<Rating> rating = service.getAllByServiceProvider(id); 
		model.addAttribute("rating",rating);
		model.addAttribute("id",id);
		return "rating";
	}
	
	@PostMapping("/addrating/{id}")
	public String addRatingPost(Model model,@ModelAttribute("rating") Rating r, BindingResult results, @PathVariable int id) {
		model.addAttribute("appName", appName);
		r.setServiceProvider(serviceProviderService.getServiceProvider(id));
		service.addRating(r);
		return "redirect:/rating/"+id;
	}
}