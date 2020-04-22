package com.semifir.bingo.models;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "users")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String firstname;
	private String lastname;
	private LocalDate birthDate;
	private String sex;
	private String contry;
	
	@ManyToOne
	@JoinColumn(name = "sponsor_id")
	private User sponsor;
	
	public User(String firstname, String lastname, LocalDate birthDate, String sex, String contry) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.birthDate = birthDate;
		this.sex = sex;
		this.contry = contry;
	}
	
	public User(Long id) {
		this.id = id;
	}
	
	@Transient
	public void setSponsorId(Long id) {
		this.sponsor = new User(id); // this.sponsor_id = id
	}

}
