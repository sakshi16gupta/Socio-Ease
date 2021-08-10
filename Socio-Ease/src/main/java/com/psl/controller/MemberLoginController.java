package com.psl.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.psl.entities.Guest;
import com.psl.entities.SocietyMember;
import com.psl.service.SocietyMemberService;

@Controller
public class MemberLoginController {
	@Value("${spring.application.name}")
    String appName;
	
	@Autowired
	SocietyMemberService service;
	
	@GetMapping("/loginMember")
	public String loginPage(Model model) {
		//System.out.println("Get Login");
		model.addAttribute("appName", appName);
		model.addAttribute("email","email");
		model.addAttribute("password","password");
		return "loginMember";
	}
	
	@PostMapping("/loginMember")
	
	public String chekMember(Model model, @ModelAttribute("email") String email, @ModelAttribute("password") String password, BindingResult results) {
		System.out.println("email: " + email + " ==== password : " + password);
		model.addAttribute("appName", appName);
		System.out.println(service.checkMember(email, password)+" in controller");
		if(service.checkMember(email, password)) {
			int id = service.findByEmail(email).getMemberId(); 
			return "redirect:/"+id;
		}
		else
			return "homepage";
	}
}
