package com.psl.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.psl.dao.IGuest;
import com.psl.dao.ISocietyMember;
import com.psl.entities.Guest;
import com.psl.entities.SocietyMember;

@Service("guestService")
public class GuestService {
	
	@Autowired
	private IGuest dao;
	
	@Autowired
	private ISocietyMember memberDao;
	
	public void addGuest(Guest e) {
		dao.save(e);
	}
	public Guest getGuest(int id) {
		return dao.findById(id).get();
	}
	
	public void updateGuest(Guest g) {
		dao.save(g);
	}
	
	public void deleteGuest(int id) {
		dao.deleteById(id);
	}
	
	public List<Guest> searchByMember(int id) {
		return dao.findBySocietyMember(memberDao.findById(id));
	}
	public Iterable<Guest> showAllGuest() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}
}
