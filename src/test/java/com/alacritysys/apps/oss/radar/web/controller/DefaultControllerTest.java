package com.alacritysys.apps.oss.radar.web.controller;

import static com.alacritysys.apps.oss.radar.ApplicationConstants.RADAR_MOBILE_VIEW;
import static com.alacritysys.apps.oss.radar.ApplicationConstants.RADAR_VIEW;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.ui.Model;

import com.alacritysys.apps.oss.radar.ApplicationConstants;
import com.alacritysys.apps.oss.radar.data.BucketItem;
import com.alacritysys.apps.oss.radar.data.CategoryBucket;
import com.alacritysys.apps.oss.radar.data.RadarData;
import com.alacritysys.apps.oss.radar.service.RadarService;

@ExtendWith(MockitoExtension.class)
class DefaultControllerTest {

	@Mock
	private RadarService radarService;
	@Mock
	private Model model;

	@InjectMocks
	private DefaultController defaultController = new DefaultController(this.radarService);

	private List<CategoryBucket> categories = new ArrayList<>();

	@BeforeEach
	void setUp() {
		createCategoriesAndItems();
		when(radarService.getBuckets()).thenReturn(categories);
	}

	private void createCategoriesAndItems() {
		for (Long i = 1L; i <= 4L; i++) {
			CategoryBucket bucket = new CategoryBucket();
			bucket.setId(i);
			bucket.getItems().add(new BucketItem());
			categories.add(bucket);
		}
	}

	@Test
	void testResponseView() {
		assertThat(this.defaultController).isNotNull();
		for (int i = 1; i <= 2; i++) {
			String viewName = this.defaultController.getRadar(model);
			assertThat(viewName).isEqualTo(RADAR_VIEW);
		}
	}

	@Test
	void testResponseMobileView() {
		assertThat(this.defaultController).isNotNull();
		for (int i = 1; i <= 2; i++) {
			String viewName = this.defaultController.getMobileRadar(model);
			assertThat(viewName).isEqualTo(RADAR_MOBILE_VIEW);
		}
	}

	@Test
	void testRadarCallsService() {
		this.defaultController.getRadar(model);
		verify(radarService).getBuckets();
		verify(model).addAttribute(Mockito.eq(ApplicationConstants.DATA), Mockito.any(RadarData.class));
	}

}
