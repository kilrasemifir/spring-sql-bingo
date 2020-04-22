package com.semifir.bingo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.semifir.bingo.models.User;

public interface UserRepository extends JpaRepository<User, Long>{

	public List<User> findBySponsor(User sponsor);
}
