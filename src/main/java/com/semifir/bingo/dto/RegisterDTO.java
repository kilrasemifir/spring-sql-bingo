package com.semifir.bingo.dto;

import java.time.LocalDate;

import lombok.Data;

@Data
public class RegisterDTO {

	private String username;
	private String email;
	private String password;
	
	private String firstname;
	private String lastname;
	private LocalDate birthDate;
	private String sex;
	private String contry;
	
}
