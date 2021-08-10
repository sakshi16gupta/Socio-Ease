package com.psl.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.psl.service.ServiceProviderService;

@Controller
public class HelpersController {
	@Value("${spring.application.name}")
    String appName;
	
	@Autowired
	ServiceProviderService serviceProviderService;
	
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
}