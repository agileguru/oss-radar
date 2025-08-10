package com.alacritysys.apps.oss.radar.model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CategoryTest {

	private Category category;

	@BeforeEach
	void setUp() {
		category = new Category(1L, this.getClass().getSimpleName(), 
				this.getClass().getName(), "http://agileguru.org", new ArrayList<>());
	}

	@Test
	void testConstructors() {
		assertThat(this.category.getId()).isNotNull();
		assertThat(this.category.getName()).isNotNull();
		assertThat(this.category.getDescription()).isNotNull();
		assertThat(this.category.getUrl()).isNotNull();

		this.category.setId(null);
		this.category.setName(null);
		this.category.setDescription(null);
		this.category.setUrl(null);

		assertThat(this.category.getId()).isNull();
		assertThat(this.category.getName()).isNull();
		assertThat(this.category.getDescription()).isNull();
		assertThat(this.category.getUrl()).isNull();
	}

}
