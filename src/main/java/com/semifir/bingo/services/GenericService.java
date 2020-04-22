package com.semifir.bingo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public abstract class GenericService<T, ID> {

	@Autowired
	private JpaRepository<T, ID> repository;
	
	public T save(T entity) {
		try {
			return this.repository.save(entity);
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
		}
	}
	
	public List<T> findAll(){
		return this.repository.findAll();
	}
	
	public T findById(ID id){
		return this.repository.findById(id)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
	}
	
	public void deleteAll() {
		this.repository.deleteAll();
	}
}
