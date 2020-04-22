package com.semifir.bingo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.semifir.bingo.dto.RegisterDTO;
import com.semifir.bingo.dto.UserDTO;
import com.semifir.bingo.models.User;
import com.semifir.bingo.services.UserService;

@RestController
@CrossOrigin
@RequestMapping("users")
public class UserController {

	@Autowired
	private UserService service;
	
	@GetMapping("")
	@ResponseStatus(code = HttpStatus.OK)
	public List<UserDTO> findAll(){
		return this.service.findAllDTO();
	}
	
	@GetMapping("{id}")
	@ResponseStatus(code = HttpStatus.OK)
	public UserDTO findById(@PathVariable Long id) {
		return this.service.findByIdDTO(id);
	}
	
	@PostMapping("")
	@ResponseStatus(code = HttpStatus.CREATED)
	public User save(@RequestBody RegisterDTO entity) {
		return this.service.save(entity);
	}
	
	@PutMapping("{rid}/sponsor/{sid}")
	@ResponseStatus(code = HttpStatus.ACCEPTED)
	public void setSponsor(@PathVariable Long rid, @PathVariable Long sid) {
		this.service.sponsor(sid, rid);
	}
	
	@GetMapping("{id}/referrals")
	@ResponseStatus(code = HttpStatus.OK)
	public List<UserDTO> findreferrals(@PathVariable Long id){
		return this.service.findReferrals(id);
	}
}
