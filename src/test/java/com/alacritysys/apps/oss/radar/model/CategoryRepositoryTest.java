package com.alacritysys.apps.oss.radar.model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class CategoryRepositoryTest {

	@Autowired
	private CategoryRepository repository;

	@BeforeEach
	void setUp() {
		assertThat(this.repository).isNotNull();
	}

	@Test
	void testGetAll() {
		Iterable<Category> allCategory = this.repository.findAll();
		debugRecords(allCategory);
	}

	private void debugRecords(Iterable<Category> allCategory) {
		for (Category category : allCategory) {
			assertThat(category.getName()).isNotNull();
		}
	}

	@Test
	void createTestCategory() {
		Category category = new Category(null, this.getClass().getSimpleName(), this.getClass().getName(),
				this.getClass().getName(),
				new ArrayList<>());
		this.repository.save(category);
		Iterable<Category> allCategories = this.repository.findAll();
		assertThat(allCategories).isNotNull().isNotEmpty();
		debugRecords(allCategories);
		this.repository.delete(category);
		allCategories = this.repository.findAll();
		debugRecords(allCategories);
		assertThat(allCategories).isNotNull().doesNotContain(category);		
	}
}
