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

import com.psl.entities.ServiceProvider;
import com.psl.service.ServiceCategoryService;
import com.psl.service.ServiceProviderService;

@Controller
public class HelpersController {
	@Value("${spring.application.name}")
    String appName;
	
	@Autowired
	ServiceProviderService serviceProviderService;
	@Autowired
	ServiceCategoryService serviceCategory;
	
//	@GetMapping("/helpers")
//	public String Helpers(Model model) {
//		model.addAttribute("appName", appName);
//		return "helpers";
//	}
	
	@GetMapping("/helpers/{categoryId}")
	public String HelpersList(Model model,@PathVariable int categoryId) {
		//System.out.println(categoryId);
		model.addAttribute("appName", appName);
		model.addAttribute("categoryId", categoryId);
		model.addAttribute("helpers", serviceProviderService.getAllByCategoryId(categoryId));
		return "helpers";
	}
	
	@GetMapping("/addhelper/{id}")
	public String addHelper(Model model, @PathVariable int id) {
		model.addAttribute("appName", appName);
		ServiceProvider helper = new ServiceProvider();
		model.addAttribute("helper",helper);
		return "addhelper";
	}
	
	@PostMapping("/addhelper/{id}")
	public String addHelperPost(Model model,@PathVariable int id,@ModelAttribute ServiceProvider s, BindingResult results) {
		model.addAttribute("appName", appName);
		s.setServiceCategory(serviceCategory.getServiceCategory(id));
		serviceProviderService.addServiceProvider(s);
		return "redirect:/addhelper/"+id;
	}
}

