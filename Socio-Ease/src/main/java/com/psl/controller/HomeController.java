package com.psl.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
	
	@Value("${spring.application.name}")
    String appName;
	
	@GetMapping({"/","/home"})
	public String sayHello(Model model) {
		model.addAttribute("appName", appName);
		return "home";
	}
	
//	@GetMapping("/checkCategories")
//	  public String checkCategories(Model model) {
//	    model.addAttribute("category", new ServiceCategory());
//	    return "checkCategories";
//	  }
//
//	  @PostMapping("/checkCategories")
//	  public String checkCategoriesSubmit(@ModelAttribute ServiceCategory category, Model model) {
//	    model.addAttribute("category", category);
//	    return "result";
//	  }
}
