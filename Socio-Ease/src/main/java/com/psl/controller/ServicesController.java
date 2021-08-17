package com.psl.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.psl.entities.ServiceCategory;
import com.psl.entities.ServiceProvider;
import com.psl.service.ServiceCategoryService;
import com.psl.service.ServiceProviderService;

@Controller
public class ServicesController {
	@Value("${spring.application.name}")
    String appName;
	
	@Autowired
	ServiceProviderService service; 
	
	@Autowired
	ServiceCategoryService serviceCategory;
	
	
	@GetMapping("/services")
	public String services(Model model) {
		model.addAttribute("appName", appName);
		model.addAttribute("categories", service.getServiceProvider(1));
		//System.out.println(service.getServiceProvider(1));
		return "services";
	}
	
	@GetMapping("/services/{categoryId}")
	public String servicesCategory(Model model, @PathVariable int categoryId) {
		
		model.addAttribute("appName", appName);
		
		return "redirect:/helpers/"+categoryId;
	}
	
	@GetMapping("/addcategory")
	public String addCategory(Model model) {
		model.addAttribute("appName", appName);
		ServiceCategory category = new ServiceCategory();
		model.addAttribute("category",category);
		return "addcategory";
	}
	
	@PostMapping("/addcategory")
	public String addCategoryPost(Model model,@ModelAttribute ServiceCategory s, BindingResult results) {
		model.addAttribute("appName", appName);
		serviceCategory.addCategory(s);
		return "redirect:/addcategory";
	}
}
