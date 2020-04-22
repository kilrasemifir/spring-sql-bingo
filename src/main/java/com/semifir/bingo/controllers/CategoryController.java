package com.semifir.bingo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.semifir.bingo.models.Campaign;
import com.semifir.bingo.models.Category;
import com.semifir.bingo.services.CategoryService;

@RestController
@RequestMapping("categories")
@CrossOrigin
public class CategoryController {

	@Autowired
	private CategoryService service;
	
	@GetMapping("")
	public List<Category> findAll(){
		return this.service.findAll();
	}
	
	@GetMapping("{id}")
	public Category findById(@PathVariable Long id) {
		return this.service.findById(id);
	}
	
	@PostMapping("")
	public Category save(@RequestBody Category entity) {
		return this.service.save(entity);
	}
	
	@GetMapping("{id}/campaigns")
	public List<Campaign> findAllCampaigns(
			@PathVariable Long id, 
			@RequestParam(value="isActive", required = false) Boolean isActive,
			@RequestParam(value="page", required = false, defaultValue = "0") Integer page,
			@RequestParam(value="size", required = false, defaultValue = "10") Integer size){
		return this.service.findAllCampaigns(id, isActive, page, size);
	}
}
