package com.psl.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.psl.entities.SocietyMember;
import com.psl.service.CommitteeMemberService;
import com.psl.service.EventNotificationService;
import com.psl.service.ServiceCategoryService;
import com.psl.service.SocietyMemberService;

@Controller
public class DashboardController {

	@Value("${spring.application.name}")
    String appName;
	//EventServices eventServices = new EventServices();
	@Autowired
	CommitteeMemberService committeeServices;
	
	@Autowired
	ServiceCategoryService categoryService;
	
	@Autowired
	EventNotificationService eventServices;
	
	@Autowired
	SocietyMemberService memberService;
	
	@GetMapping("/{id}")
	public String dashboard(Model model, @PathVariable int id) {
		model.addAttribute("appName", appName);
		SocietyMember member = memberService.getSocietyMember(id);
		model.addAttribute("name",member.getMemberName());
		model.addAttribute("id",id);
		model.addAttribute("events",eventServices.showAllEvent());
		model.addAttribute("committee",committeeServices.showCommitteeMembers());
		model.addAttribute("categories",categoryService.showServiceCategory());
		return "dashboard";
	}
	
	@GetMapping("/categories")
	public String categories(Model model) {
		model.addAttribute("appName", appName);
		model.addAttribute("categories",categoryService.getServiceCategory(1));
		return "categories";
	}
}
