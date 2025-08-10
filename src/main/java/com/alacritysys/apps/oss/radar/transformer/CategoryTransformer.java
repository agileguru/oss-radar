package com.alacritysys.apps.oss.radar.transformer;

import java.util.Collection;

import org.springframework.stereotype.Component;

import com.alacritysys.apps.oss.radar.data.BucketItem;
import com.alacritysys.apps.oss.radar.data.CategoryBucket;
import com.alacritysys.apps.oss.radar.model.Category;
import com.alacritysys.apps.oss.radar.model.Item;

@Component
public class CategoryTransformer {
	
	public boolean entityToView(Category category, CategoryBucket bucket) {
		bucket.setId(category.getId());
		bucket.setBucketName(category.getName());
		bucket.setBucketDesc(category.getDescription());
		bucket.setBucketLink(category.getUrl());
		for (Item item : category.getItems()) {
			BucketItem bucketItem = new BucketItem();
			bucketItem.setId(item.getId());
			bucketItem.setBucketItemName(item.getItemName());
			bucketItem.setBucketItemDesc(item.getItemDesc());
			bucketItem.setBucketItemUrl(item.getItemUrl());
			bucketItem.setBucketItemStatusDate(item.getStatusDate());
			bucketItem.setBucketItemStatus(item.getStatus());
			bucket.getItems().add(bucketItem);
		}
		return true;
	}

	public boolean entityToView(Collection<Category> categories, Collection<CategoryBucket> buckets) {
		for (Category category : categories) {
			CategoryBucket bucket = new CategoryBucket();
			entityToView(category, bucket);
			buckets.add(bucket);
		}
		return true;
	}
}
