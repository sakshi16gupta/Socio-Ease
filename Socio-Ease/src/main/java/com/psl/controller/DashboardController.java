package com.psl.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DashboardController {

	@Value("${spring.application.name}")
    String appName;
	//EventServices eventServices = new EventServices();
	//CommitteeServices committeeServices = new CommitteeServices();
	
	@GetMapping("/{id}")
	public String dashboard(Model model, @PathVariable int id) {
		model.addAttribute("appName", appName);
		model.addAttribute("id",id);
		//model.addAttribute("events",eventServices.getEvents());
		//model.addAttribute("committee",committeeServices.getCommitteeMembers());
		return "dashboard";
	}
}
