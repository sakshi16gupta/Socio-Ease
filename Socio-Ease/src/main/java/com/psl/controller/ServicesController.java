package com.psl.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.psl.service.ServiceProviderService;

@Controller
public class ServicesController {
	@Value("${spring.application.name}")
    String appName;
	
	@Autowired
	ServiceProviderService service; 
	
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
}
