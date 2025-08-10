package com.alacritysys.apps.oss.radar.web.controller.rest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.alacritysys.apps.oss.radar.data.CategoryBucket;
import com.alacritysys.apps.oss.radar.service.RadarService;

@ExtendWith(MockitoExtension.class)
class RadarDataRestControllerTest {

	@Mock
	private RadarService radarService;
	
	@InjectMocks
	private RadarDataRestController controller = new RadarDataRestController(this.radarService);
	private CategoryBucket testBucket;

	@BeforeEach
	void setUp() {
		testBucket = new CategoryBucket();
		when(radarService.getBuckets()).thenReturn(Collections.singletonList(testBucket));
	}

	@Test
	void testCanGetAllBuckets() {
		ResponseEntity<List<CategoryBucket>> buckets = controller.getAllBuckets();
		assertThat(buckets).isNotNull();
		assertThat(buckets.getStatusCode()).isNotNull().isEqualTo(HttpStatus.OK);
		assertThat(buckets.getBody()).isNotNull().isNotEmpty().hasSize(1).contains(testBucket);
		verify(radarService).getBuckets();
	}

}
