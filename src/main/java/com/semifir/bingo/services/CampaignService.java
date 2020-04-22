package com.semifir.bingo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.semifir.bingo.models.Campaign;
import com.semifir.bingo.repositories.CampaignRepository;

@Service
public class CampaignService extends GenericService<Campaign, Long> {

	@Autowired
	private CampaignRepository repository;
	
	public List<Campaign> findAllByCategoriesAndIsActive(Long id, Boolean isActive, int page, int size){
		return this.repository.findAllByCategoriesIdAndIsActive(id, isActive, PageRequest.of(page, size));
	}
	
	public List<Campaign> findAllCampaigns(Long id, int page, int size){
		return this.repository.findAllByCategoriesId(id, PageRequest.of(page, size));
	}
}
