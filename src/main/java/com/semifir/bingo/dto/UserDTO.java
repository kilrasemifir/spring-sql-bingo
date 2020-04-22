package com.semifir.bingo.dto;

import com.semifir.bingo.models.User;

import lombok.Data;

@Data
public class UserDTO {

	private String firstname;
	private String lastname;
	private String sex;
	private String contry;
	private String sponsorName;
	
	public UserDTO(User user) {
		this.firstname = user.getFirstname();
		this.lastname = user.getLastname();
		this.sex = user.getSex();
		this.contry = user.getContry();
		if (user.getSponsor() != null)
			this.sponsorName = user.getSponsor().getFirstname(); 
	}
}
