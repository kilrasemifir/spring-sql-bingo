package com.semifir.bingo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.semifir.bingo.models.Category;

public interface CategoryRepository extends JpaRepository<Category, Long>{

}
