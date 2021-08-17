package com.psl.security;

 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

 

import com.psl.dao.IUserDao;
import com.psl.entities.User;

 

public class UserDetailsServiceImpl implements UserDetailsService {
    
    @Autowired
    private IUserDao userDao;
    
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user =userDao.getUserByUsername(username);
        if(user==null) {
            throw new UsernameNotFoundException("Could not find User");
        }
        return new MyUserDetails(user);
    }

 

}