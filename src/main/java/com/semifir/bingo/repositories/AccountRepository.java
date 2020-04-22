package com.semifir.bingo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.semifir.bingo.models.Account;

public interface AccountRepository extends JpaRepository<Account, Long>{

}
