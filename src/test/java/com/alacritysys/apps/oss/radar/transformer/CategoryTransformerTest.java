package com.alacritysys.apps.oss.radar.transformer;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Collections;

import org.junit.jupiter.api.Test;

import com.alacritysys.apps.oss.radar.data.CategoryBucket;
import com.alacritysys.apps.oss.radar.model.Category;
import com.alacritysys.apps.oss.radar.model.Item;

class CategoryTransformerTest {

	private Item item = new Item();
	private CategoryTransformer categoryTransformer = new CategoryTransformer();
	private Category category = new Category(5l, this.getClass().getName(), 
			this.getClass().getSimpleName(), this.getClass().getPackage().getName(),
			Collections.singletonList(item));

	@Test
	void testProperties() {
		CategoryBucket categoryBucket = new CategoryBucket();
		categoryTransformer.entityToView(category, categoryBucket);
		assertThat(categoryBucket.getId()).isEqualTo(category.getId());
		assertThat(categoryBucket.getBucketName()).isEqualTo(category.getName());
		assertThat(categoryBucket.getBucketDesc()).isEqualTo(category.getDescription());
		assertThat(categoryBucket.getBucketLink()).isEqualTo(category.getUrl());
		
		assertThat(categoryBucket.getItems()).isNotNull().isNotEmpty().hasSize(category.getItems().size());
		assertThat(categoryBucket.getItems().get(0).getBucketItemName()).isEqualTo(item.getItemName());
	}

}
