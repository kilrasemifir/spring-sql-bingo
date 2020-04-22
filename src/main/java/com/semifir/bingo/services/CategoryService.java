package com.semifir.bingo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.semifir.bingo.models.Campaign;
import com.semifir.bingo.models.Category;

@Service
public class CategoryService extends GenericService<Category, Long>{

	@Autowired
	private CampaignService campaignService;
	
	public List<Campaign> findAllCampaigns(Long id, Boolean isActive, Integer page, Integer size){
		if (isActive == null) {
			return this.campaignService.findAllCampaigns(id, page, size);
		}else {
			return this.campaignService.findAllByCategoriesAndIsActive(id, isActive, page, size);
		}
	}
}
