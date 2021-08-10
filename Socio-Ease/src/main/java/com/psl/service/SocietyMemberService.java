package com.psl.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.psl.dao.ISocietyMember;
import com.psl.entities.SocietyMember;

@Service("societyMemberService")
public class SocietyMemberService {
	
	@Autowired
	private ISocietyMember dao;
	
	public void addSocietyMember(SocietyMember e) {
		dao.save(e);
	}
	public SocietyMember getSocietyMember(int id) {
		return dao.findById(id).get();
	}
	
	public void updateSocietyMember(SocietyMember g) {
		dao.save(g);
	}
	
	public void deleteSocietyMember(int id) {
		dao.deleteById(id);
	}
	
	public boolean checkMember(String email,String password) {
		//System.out.println("email: " + email + " ==== password : " + password);
		System.out.println((dao.findByEmail(email)!=null)+" in service checking email");
		if(dao.findByEmail(email)!=null) {
			System.out.println(dao.findByEmail(email).getPassword().equals(password)+" in service checking passowrd");
			if(dao.findByEmail(email).getPassword().equals(password)) {
				return true;
			}
		}
		return false;
	}
	
	public SocietyMember findByEmail(String email) {
		return dao.findByEmail(email);
	}
}
