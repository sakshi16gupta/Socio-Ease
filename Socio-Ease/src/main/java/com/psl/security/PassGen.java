package com.psl.security;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PassGen {
	public static void main(String[] args) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		
		System.out.println(encoder.encode("user1"));
		System.out.println(encoder.encode("admin"));
	}
}

//$2a$10$DVJT9XYDpnBZqOcTKHdlKOHljxbYVYqk7W.DTHOw.ub3oRsr6hhwy -- user1
//$2a$10$2JZcaP3gox6hAZtkUFOqnenVqNnqM1WVZYm5OE0u2MKH2hSxeklH6 -- admin