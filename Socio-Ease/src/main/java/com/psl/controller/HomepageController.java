package com.psl.controller;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.psl.entities.EventNotification;
import com.psl.service.CommitteeMemberService;
import com.psl.service.EventNotificationService;

@Controller
public class HomepageController {
	@Value("${spring.application.name}")
    String appName;
	
	@Autowired
	EventNotificationService eventServices;
	@Autowired
	CommitteeMemberService committeeServices;
	
		
	@GetMapping("/homepage")
	public String homepage(Model model) {
		//eventServices.addEvent(new EventNotification(2,"raksha bandhan","22th august 10 am",LocalDate.now()));
		model.addAttribute("appName", appName);
		model.addAttribute("events",eventServices.showAllEvent());
		model.addAttribute("committee",committeeServices.showCommitteeMembers());
		return "homepage";
	}
}
