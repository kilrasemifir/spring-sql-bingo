package com.semifir.bingo.models;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "comptes")
@Data
@NoArgsConstructor
public class Account {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String username;
	private String email;
	private String password;
	private Boolean isEnabled;
	private LocalDate createAt;
	
	@OneToOne
	private User user;

	public Account(String username, String email, String password, Boolean isEnabled, LocalDate createAt, User user) {
		super();
		this.username = username;
		this.email = email;
		this.password = password;
		this.isEnabled = isEnabled;
		this.createAt = createAt;
		this.user = user;
	}
	
	
}
