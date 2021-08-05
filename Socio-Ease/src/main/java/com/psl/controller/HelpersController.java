package com.psl.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class HelpersController {
	@Value("${spring.application.name}")
    String appName;
	//HelpersServices helpersServices = new HelpersServices();
	
//	@GetMapping("/helpers")
//	public String Helpers(Model model) {
//		model.addAttribute("appName", appName);
//		return "helpers";
//	}
	
	@GetMapping("/helpers/{name}")
	public String HelpersList(Model model,@PathVariable String name) {
		model.addAttribute("appName", appName);
		//model.addAttribute("helpersList", helpersServices.getAllByName(name));
		return "helpers";
	}
}