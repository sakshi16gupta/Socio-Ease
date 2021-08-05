package com.psl.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class ServicesController {
	@Value("${spring.application.name}")
    String appName;
	//ServicesServices servicesServices = new ServicesServices(); 
	
	@GetMapping("/services")
	public String services(Model model) {
		model.addAttribute("appName", appName);
		//model.addAttribute("categories", servicesServices.getAllServices());
		return "services";
	}
	
	@GetMapping("/services/{name}")
	public String servicesCategory(Model model, @PathVariable String name) {
		model.addAttribute("appName", appName);
		return "helpers/{name}";
	}
}
