package com.semifir.bingo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.semifir.bingo.models.Campaign;
import com.semifir.bingo.services.CampaignService;

@RestController
@RequestMapping("campaigns")
@CrossOrigin
public class CampaignController {
	@Autowired
	private CampaignService service;
	
	@GetMapping("")
	public List<Campaign> findAll(){
		return this.service.findAll();
	}
	
	@PostMapping("")
	public Campaign save(@RequestBody Campaign entity) {
		return this.service.save(entity);
	}
	
	@GetMapping("{id}")
	public Campaign findById(@PathVariable Long id) {
		return this.service.findById(id);
	}
}
