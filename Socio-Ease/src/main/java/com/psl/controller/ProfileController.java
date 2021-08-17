package com.psl.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.psl.entities.CommitteeMember;
import com.psl.entities.SocietyMember;
import com.psl.service.CommitteeMemberService;
import com.psl.service.GuestService;
import com.psl.service.SocietyMemberService;

@Controller
public class ProfileController {
	
	@Value("${spring.application.name}")
    String appName;
	
	@Autowired
	private SocietyMemberService service; 
	
	@Autowired
	private GuestService guestService;
	
	@Autowired
	private CommitteeMemberService committeeMemberService;
	
	@GetMapping("/profile/{id}")
	public String profile(Model model,@PathVariable int id) {
		
		model.addAttribute("appName", appName);
		model.addAttribute("id",id);
		
		model.addAttribute("member", service.getSocietyMember(id));
		model.addAttribute("guests",guestService.searchByMember(id));

		return "profile";
	}
	
	@GetMapping("/update/{id}")
	public String registerG(Model model,@PathVariable int id) {
		SocietyMember s = service.getSocietyMember(id);
		model.addAttribute("societymember",s);
		return "profileUpdate";
	}
	
	@PostMapping("/update/{id}")
	public String registerGuest(Model model, @PathVariable int id,@ModelAttribute SocietyMember s, BindingResult results) {
		s.setPassword(service.getSocietyMember(id).getPassword());
		s.setMemberId(id);
		s.setPhoto(service.getSocietyMember(id).getPhoto());
		s.setEmail(service.getSocietyMember(id).getEmail());
		service.updateSocietyMember(s);
		return "redirect:/profile/"+id;
	}
	
	@GetMapping("/members")
	public String members(Model model) {
		Iterable<SocietyMember> members = service.findAll();
		model.addAttribute("members",members);
		return "members";
	}

}