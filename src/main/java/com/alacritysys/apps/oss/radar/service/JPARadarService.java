package com.alacritysys.apps.oss.radar.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.alacritysys.apps.oss.radar.data.CategoryBucket;
import com.alacritysys.apps.oss.radar.model.Category;
import com.alacritysys.apps.oss.radar.model.CategoryRepository;
import com.alacritysys.apps.oss.radar.transformer.CategoryTransformer;
import com.google.common.collect.Lists;

@Service
public class JPARadarService implements RadarService {

	private CategoryRepository categoryRepository;
	
	private CategoryTransformer transformer;

	public JPARadarService(CategoryRepository categoryRepository, CategoryTransformer transformer) {
		this.categoryRepository = categoryRepository;
		this.transformer = transformer;
	}
	/**
	 * @return List of {@link Category} in the DB
	 */
	@Override
	public List<CategoryBucket> getBuckets() {
		List<Category> allCategories = Lists.newArrayList(this.categoryRepository.findAll());
		List<CategoryBucket> buckets = new ArrayList<>(allCategories.size());
		this.transformer.entityToView(allCategories, buckets);
		return buckets;
	}
}
