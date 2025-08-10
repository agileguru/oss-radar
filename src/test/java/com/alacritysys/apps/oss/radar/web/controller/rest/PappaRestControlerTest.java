package com.alacritysys.apps.oss.radar.web.controller.rest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alacritysys.apps.oss.radar.data.CategoryBucket;
import com.alacritysys.apps.oss.radar.service.RadarService;

@ExtendWith(MockitoExtension.class)
class PappaRestControlerTest {

	private static final String RAMAN_THE_TALL_GENIUS = "Raman The Tall Genius";

	@Mock
	private RadarService radarService;
	
	@InjectMocks
	private RadarDataRestController controller;

	@Test
	void testServiceCalled() {
		CategoryBucket category  = new CategoryBucket();
		category.setBucketName(RAMAN_THE_TALL_GENIUS);
		when(radarService.getBuckets()).thenReturn(Collections.singletonList(category));
		
		ResponseEntity<List<CategoryBucket>> buckets = controller.getAllBuckets();
		
		assertThat(buckets.getBody()).isNotNull();
		verify(radarService).getBuckets();
		assertThat(buckets.getStatusCode()).isEqualTo(HttpStatus.OK);
		assertThat(buckets.getBody()).isNotNull().isNotEmpty().hasSize(1);
		
		assertThat(buckets.getBody().get(0).getBucketName()).
		isNotNull().isNotEmpty().isEqualTo(RAMAN_THE_TALL_GENIUS);
	}
	
	
	@Test
	void testIsAnnotatedAsRestController() {
		assertThat(controller.getClass().getAnnotations()[0]).isInstanceOf(RestController.class);
		assertThat(controller.getClass().getMethods()[0].getAnnotations()[0]).isInstanceOf(GetMapping.class);
	}
	

}
