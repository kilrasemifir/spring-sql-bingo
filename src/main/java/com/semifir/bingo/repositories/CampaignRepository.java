package com.semifir.bingo.repositories;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.semifir.bingo.models.Campaign;

public interface CampaignRepository extends JpaRepository<Campaign, Long>, PagingAndSortingRepository<Campaign, Long>{

	public List<Campaign> findAllByCategoriesIdAndIsActive(Long id, Boolean isActive, Pageable peaPageable);

	public List<Campaign> findAllByCategoriesId(Long id, Pageable peaPageable);
}
