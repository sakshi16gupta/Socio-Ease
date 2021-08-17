package com.psl.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.psl.entities.CommitteeMember;
import com.psl.service.CommitteeMemberService;

@Controller
public class CommitteeMemberController {

	@Value("${spring.application.name}")
    String appName;
	
	@Autowired
	CommitteeMemberService service;
	
	
	@GetMapping("/addcommitteemember")
	public String addCommitteeMember(Model model) {
		CommitteeMember s = new CommitteeMember();
		model.addAttribute("member",s);
		return "addcommitteemember";
	}
	
	@PostMapping("/addcommitteemember")
	public String addCommitteeMemberPost(Model model,@ModelAttribute CommitteeMember s, BindingResult results) {
		service.addCommitteeMember(s);
		return "redirect:/addcommitteemember";
	}
	
	@GetMapping("/editcommitteemember/{id}")
	public String editCommitteeMember(Model model,@PathVariable int id) {
		CommitteeMember s = service.getCommiteeMember(id);
		model.addAttribute("id",id);
		model.addAttribute("member",s);
		return "editcommitteemember";
	}
	
	@PostMapping("/editcommitteemember/{id}")
	public String editCommitteeMemberPost(Model model,@ModelAttribute CommitteeMember s, BindingResult results,@PathVariable int id) {
		s.setId(id);
		service.updateCommitteeMember(s);
		return "redirect:/editcommitteemember/"+id;
	}
	
	@GetMapping("/deletecommitteemember/{id}")
	public String deleteCommitteeMember(Model model,@PathVariable("id") int id) {
		service.deleteCommitteeMember(id);
		return "delete";
	}
	
//	@GetMapping("/eventRegister")
//	public String guestG1(Model model) {
//		EventNotification e = new EventNotification();
//		model.addAttribute("event",e);
//		return "eventRegister";
//	}
//	
//	@PostMapping("/eventRegister")
//	public String registerEvent(Model model, @ModelAttribute EventNotification e, BindingResult results) {
//		e.setTimestamp(LocalDate.now());
//		service.addEvent(e);
//		return "redirect:/eventRegister";
//		
//	}
//	
//	@GetMapping("/eventg/{id}")
//	public String getEvent(@PathVariable int id, Model model) {
//		
//		model.addAttribute("event", service.getEvent(id));
//		
//		return "eventg";
//	}
//	
//	
//	
//	@RequestMapping("/view/event")
//	public String viewEvent(Model model) {
//		model.addAttribute("listEvent",service.showAllEvent());
//		return "event";
//	}
//
//	@RequestMapping(value ="/save/event", method =RequestMethod.POST)
//	public String saveEvent(@ModelAttribute EventNotification event) {
//		service.addEvent(event);
//		return "redirect:/view/event";
//	}
//	
//	
//	@RequestMapping("/edit/event/{eid}")
//	public ModelAndView showEditStudentPage(@PathVariable (name="eid") Integer eid) {
//		ModelAndView mav=new ModelAndView("edit_event");
//		EventNotification event=service.getEvent(eid);
//		mav.addObject("event",event);
//		return mav;
//	}
//	
//	@RequestMapping("/delete/event/{eid}")
//	public String deleteStudentPage(@PathVariable (name="eid") Integer eid) {
//		service.deleteEvents(eid);
//		return "redirect:/view/event";
//	}
	
}
