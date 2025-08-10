package com.alacritysys.apps.oss.radar.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.alacritysys.apps.oss.radar.data.CategoryBucket;
import com.alacritysys.apps.oss.radar.model.Category;
import com.alacritysys.apps.oss.radar.model.CategoryRepository;
import com.alacritysys.apps.oss.radar.transformer.CategoryTransformer;

@ExtendWith(MockitoExtension.class)
class RadarServiceTest {

	@Mock
	private CategoryRepository categoryRepository;
	
	@Mock
	private CategoryTransformer transformer;

	@InjectMocks
	private RadarService jpaRadarService = new JPARadarService(this.categoryRepository, this.transformer);

	private Category category;

	@BeforeEach
	void setUp() {
		category = new Category(1L, this.getClass().getName(), this.getClass().getName(), 
				this.getClass().getName(),
				new ArrayList<>());
		when(categoryRepository.findAll()).thenReturn(Collections.singletonList(category));
		when(transformer.entityToView(Mockito.anyCollection(), Mockito.anyCollection())).thenCallRealMethod();
	}

	@Test
	void testServiceCallsRepository() {
		List<CategoryBucket> categories = jpaRadarService.getBuckets();
		verify(categoryRepository).findAll();
		verify(transformer).entityToView(Mockito.anyCollection(), Mockito.anyCollection());
		assertThat(categories).isNotNull().isNotEmpty().hasSize(1);
	}

}
