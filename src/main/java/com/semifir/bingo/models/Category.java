package com.semifir.bingo.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "categories")
public class Category {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String name;
	/*
	@ManyToMany
	@JoinTable(
			name = "categories_campaigns",
			joinColumns = @JoinColumn(name = "category_id"),
			inverseJoinColumns = @JoinColumn(name = "campaign_id"))
	// @ManyToMany(mappedBy = "categories_campaignes")
	private Set<Campaign> campaigns = new HashSet<>();
	*/
}
