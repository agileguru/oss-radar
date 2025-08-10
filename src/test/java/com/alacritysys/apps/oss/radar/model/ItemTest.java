package com.alacritysys.apps.oss.radar.model;

import static org.assertj.core.api.Assertions.assertThat;

import java.sql.Date;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.alacritysys.apps.oss.radar.ApplicationConstants;

class ItemTest {

	private Item categoryItem;

	@BeforeEach
	void setUp() {
		new Item();
		categoryItem = new Item(1L, this.getClass().getSimpleName(), 
				this.getClass().getName(), "https://kubernetes.io",
				new Date(System.nanoTime()),ApplicationConstants.ITEM_STATUS_HOLD);
	}

	@Test
	void testConstructors() {
		assertThat(this.categoryItem.getId()).isNotNull();
		assertThat(this.categoryItem.getItemName()).isNotNull();
		assertThat(this.categoryItem.getItemName()).isNotNull();
		assertThat(this.categoryItem.getItemUrl()).isNotNull();

		this.categoryItem.setId(null);
		this.categoryItem.setItemName(null);
		this.categoryItem.setItemDesc(null);
		this.categoryItem.setItemUrl(null);

		assertThat(this.categoryItem.getId()).isNull();
		assertThat(this.categoryItem.getItemName()).isNull();
		assertThat(this.categoryItem.getItemName()).isNull();
		assertThat(this.categoryItem.getItemUrl()).isNull();
	}


}
