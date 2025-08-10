package com.alacritysys.apps.oss.radar.data;

import static org.assertj.core.api.Assertions.assertThat;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.alacritysys.apps.oss.radar.ApplicationConstants;
import com.alacritysys.apps.oss.radar.model.Category;
import com.alacritysys.apps.oss.radar.model.Item;
import com.alacritysys.apps.oss.radar.transformer.CategoryTransformer;

class CategoryBucketTest {

	private CategoryTransformer transformer;
	private Category category;
	private Item item;

	@BeforeEach
	void setUp() {
		transformer = new CategoryTransformer();
		item = new Item(5L, this.getClass().getName(), this.getClass().getName(), this.getClass().getName(),
				new Date(System.nanoTime()), ApplicationConstants.ITEM_STATUS_HOLD);
		category = new Category(5L, this.getClass().getName(), this.getClass().getName(), this.getClass().getName(),
				Collections.singletonList(item));
	}

	@Test
	void testCategoryHasItems() {
		ArrayList<CategoryBucket> buckets = new ArrayList<>(0);
		transformer.entityToView(Collections.singletonList(category), buckets);
		assertThat(buckets).isNotNull().isNotEmpty().hasSize(1);
		List<BucketItem> items = buckets.get(0).getItems();
		assertThat(items).isNotNull().isNotEmpty().hasSize(1);
		BucketItem bucketItem = items.get(0);
		assertThat(bucketItem).isNotNull();

		assertThat(bucketItem.getId()).isEqualTo(item.getId());
		assertThat(bucketItem.getBucketItemName()).isEqualTo(item.getItemName());
		assertThat(bucketItem.getBucketItemDesc()).isEqualTo(item.getItemDesc());
		assertThat(bucketItem.getBucketItemUrl()).isEqualTo(item.getItemUrl());

		buckets.get(0).setItems(Collections.emptyList());
	}

}
