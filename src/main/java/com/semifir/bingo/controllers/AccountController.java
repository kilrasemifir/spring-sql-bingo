package com.semifir.bingo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.semifir.bingo.models.Account;
import com.semifir.bingo.services.AccountService;

@RestController
@RequestMapping("accounts")
@CrossOrigin
public class AccountController {
	@Autowired
	private AccountService service;
	
	@GetMapping("")
	public List<Account> findAll(){
		return this.service.findAll();
	}
	
	@GetMapping("{id}")
	public Account findById(@PathVariable Long id) {
		return this.service.findById(id);
	}
	
}
