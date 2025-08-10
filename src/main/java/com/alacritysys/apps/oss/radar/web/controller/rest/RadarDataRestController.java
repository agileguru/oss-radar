package com.alacritysys.apps.oss.radar.web.controller.rest;

import static com.alacritysys.apps.oss.radar.ApplicationConstants.URI_MAPPING_GET_ALL_BUCKETS;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alacritysys.apps.oss.radar.data.CategoryBucket;
import com.alacritysys.apps.oss.radar.service.RadarService;

@RestController
public class RadarDataRestController {
	
	private RadarService radarService;
	
	public RadarDataRestController(RadarService radarService) {
		this.radarService = radarService;
	}

	@GetMapping(URI_MAPPING_GET_ALL_BUCKETS)
	public ResponseEntity<List<CategoryBucket>> getAllBuckets() {
		return new ResponseEntity<>(radarService.getBuckets(),HttpStatus.OK);
	}

}
