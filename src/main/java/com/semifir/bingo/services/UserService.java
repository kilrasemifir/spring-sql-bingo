package com.semifir.bingo.services;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.semifir.bingo.dto.RegisterDTO;
import com.semifir.bingo.dto.UserDTO;
import com.semifir.bingo.models.Account;
import com.semifir.bingo.models.User;
import com.semifir.bingo.repositories.UserRepository;

@Service
public class UserService extends GenericService<User, Long>{

	@Autowired
	private UserRepository userRepository;
	@Autowired
	private AccountService accountService;
	
	public User save(RegisterDTO dto) {
		User user = new User(
				dto.getFirstname(),
				dto.getLastname(),
				dto.getBirthDate(),
				dto.getSex(),
				dto.getContry());
		user = this.userRepository.save(user);
		Account account = new Account(
				dto.getUsername(),
				dto.getEmail(),
				dto.getPassword(),
				false, // isEnable
				LocalDate.now(), // created at
				user); // user
		this.accountService.save(account);
		return user;
	}
	
	public void sponsor(Long sponsorId, Long referralId) {
		User referral = this.findById(referralId);
		if (referral.getSponsor() != null) throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "sponsor alraidy set");
		referral.setSponsorId(sponsorId); // set foreign key
		this.save(referral);
	}
	
	public List<UserDTO> findReferrals(Long id){
		return this.userRepository.findBySponsor(new User(id)).stream()
				.map(UserService::toDTO)
				.collect(Collectors.toList());
	}
	
	public UserDTO findByIdDTO(Long id) {
		return toDTO(this.findById(id));
	}
	
	public List<UserDTO> findAllDTO(){
		return this.findAll().stream()
				.map(UserService::toDTO)
				.collect(Collectors.toList());
	}
	
	private static UserDTO toDTO(User user) {
		return new UserDTO(user);
	}
	
}
