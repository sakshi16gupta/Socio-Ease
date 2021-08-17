package com.psl.controller;

import java.time.LocalDate;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.psl.entities.Guest;
import com.psl.service.GuestService;
import com.psl.service.SocietyMemberService;

@Controller
public class GuestController {
	
	@Value("${spring.application.name}")
    String appName;
	
	@Autowired
	private GuestService service; 
	@Autowired
	private SocietyMemberService memberService; 
	
	@GetMapping("/guest/{id}")
	public String guest(Model model,@PathVariable int id) {
		Guest g = new Guest();
		model.addAttribute("guest",g);
		return "guest";
		
	}
	
	@PostMapping("/guest/{id}")
	public String registerGuest(Model model, @ModelAttribute Guest g, BindingResult results,@PathVariable int id) {
		
		
		g.setGuestCode(new Random().nextInt((9999 - 100) + 1) + 10);
		g.setSocietyMember(memberService.getSocietyMember(id));
		g.setTimestamp(LocalDate.now());
		service.addGuest(g);
		return "redirect:/profile/"+id;
	}
}