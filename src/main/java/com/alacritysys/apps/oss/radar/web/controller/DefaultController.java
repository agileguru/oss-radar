package com.alacritysys.apps.oss.radar.web.controller;

import static com.alacritysys.apps.oss.radar.ApplicationConstants.CONFIG_RADAR_OFFSET;
import static com.alacritysys.apps.oss.radar.ApplicationConstants.CONFIG_RADAR_WIDTH;
import static com.alacritysys.apps.oss.radar.ApplicationConstants.DATA;
import static com.alacritysys.apps.oss.radar.ApplicationConstants.ITEM_STATUS_ADOPT;
import static com.alacritysys.apps.oss.radar.ApplicationConstants.ITEM_STATUS_ASSESS;
import static com.alacritysys.apps.oss.radar.ApplicationConstants.ITEM_STATUS_HOLD;
import static com.alacritysys.apps.oss.radar.ApplicationConstants.ITEM_STATUS_TRIAL;
import static com.alacritysys.apps.oss.radar.ApplicationConstants.RADAR_MAPPING;
import static com.alacritysys.apps.oss.radar.ApplicationConstants.RADAR_MOBILE_MAPPING;
import static com.alacritysys.apps.oss.radar.ApplicationConstants.RADAR_MOBILE_VIEW;
import static com.alacritysys.apps.oss.radar.ApplicationConstants.RADAR_VIEW;
import static java.util.HashMap.newHashMap;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.geo.Circle;
import org.springframework.data.geo.Point;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.alacritysys.apps.oss.radar.data.BucketItem;
import com.alacritysys.apps.oss.radar.data.CategoryBucket;
import com.alacritysys.apps.oss.radar.data.RadarCircle;
import com.alacritysys.apps.oss.radar.data.RadarData;
import com.alacritysys.apps.oss.radar.service.RadarService;
import com.google.common.collect.Maps;

@Controller
public class DefaultController {
	private static final Logger LOGGER = LoggerFactory.getLogger(DefaultController.class);

	private static final double HALF_DIVIDER = 2.0;
	private static final String[] CIRCLES = { ITEM_STATUS_ADOPT, ITEM_STATUS_ASSESS, ITEM_STATUS_TRIAL,
			ITEM_STATUS_HOLD };

	private RadarService radarService;

	@Value(CONFIG_RADAR_WIDTH)
	private Integer radarWidth = 800;

	@Value(CONFIG_RADAR_OFFSET)
	private Integer viewOffset = 10;

	private Map<String, RadarData> dataMap = newHashMap(2);
	
	public DefaultController( RadarService radarService) {
		this.radarService = radarService;
	}

	/**
	 * @return The Radar View ( The web page )
	 */
	@ResponseStatus(HttpStatus.OK)
	@GetMapping(RADAR_MAPPING)
	public String getRadar(Model model) {
		if (!dataMap.containsKey(RADAR_MAPPING)) {
			LOGGER.info("The cache Map with key '{}' is empty so populating it... ", RADAR_MAPPING);
			List<CategoryBucket> categories = this.radarService.getBuckets();
			RadarData radarData = prepareData(categories, this.radarWidth, this.viewOffset);
			dataMap.put(RADAR_MAPPING, radarData);
			LOGGER.info("The cache Map with key '{}' is populated ", RADAR_MAPPING);
		}
		LOGGER.info("Getting The data from the cache Map with key '{}' ", RADAR_MAPPING);
		model.addAttribute(DATA, dataMap.get(RADAR_MAPPING));
		return RADAR_VIEW;
	}

	/**
	 * @return The Radar View ( The web page )
	 */
	@ResponseStatus(HttpStatus.OK)
	@GetMapping(RADAR_MOBILE_MAPPING)
	public String getMobileRadar(Model model) {
		if (!dataMap.containsKey(RADAR_MOBILE_MAPPING)) {
			LOGGER.info("The cache Map with key '{}' is empty ", RADAR_MOBILE_MAPPING);
			List<CategoryBucket> categories = this.radarService.getBuckets();
			RadarData radarData = prepareData(categories, this.radarWidth / 2, this.viewOffset / 2);
			dataMap.put(RADAR_MOBILE_MAPPING, radarData);
			LOGGER.info("The cache Map with key '{}' is populated ", RADAR_MOBILE_MAPPING);
		}
		LOGGER.info("Getting The data from the cache Map with key '{}' ", RADAR_MOBILE_MAPPING);
		model.addAttribute(DATA, dataMap.get(RADAR_MOBILE_MAPPING));
		return RADAR_MOBILE_VIEW;
	}

	public RadarData prepareData(List<CategoryBucket> categories, Integer width, Integer offset) {
		RadarData data = new RadarData();
		data.setViewWidth(width + offset);
		data.setPadding(offset / 2);

		double centerX = width / HALF_DIVIDER;
		double centerY = width / HALF_DIVIDER;
		double baseRadius = width / HALF_DIVIDER;
		double centerOffset = offset / HALF_DIVIDER;
		for (int i = CIRCLES.length; i > 0; i--) {
			String name = CIRCLES[i - 1];
			Circle circle = new Circle(centerX + centerOffset, centerY + centerOffset, baseRadius * i / CIRCLES.length);
			RadarCircle radarCircle = new RadarCircle(name, circle, baseRadius * (i - 1) / CIRCLES.length);
			data.getCircles().put(name, radarCircle);
		}
		data.setTotalCircles(data.getCircles().size());
		setupBucketsAndItems(data, categories, offset);
		return data;
	}

	public void setupBucketsAndItems(RadarData data, List<CategoryBucket> categories, Integer offset) {
		Map<String, Double> colMap = Maps.newHashMapWithExpectedSize(data.getCircles().size());
		Map<String, Double> rowMap = Maps.newHashMapWithExpectedSize(data.getCircles().size());
		for (CategoryBucket categoryBucket : categories) {
			resetStatusByCategory(data, offset, colMap, rowMap);
			int itemCount = 1;
			for (BucketItem item : categoryBucket.getItems()) {

				String itemStatus = item.getBucketItemStatus();
				Double colOffset = colMap.get(itemStatus);
				Double rowOffset = rowMap.get(itemStatus);
				RadarCircle radarCircle = data.getCircles().get(itemStatus);
				Point point = radarCircle.getCircle().getCenter();

				if (categoryBucket.getId() % 2 == 1) {
					item.setPositionX(point.getX() - radarCircle.getCircle().getRadius().getValue() + colOffset);
				} else {
					item.setPositionX(point.getX() + radarCircle.getCircle().getRadius().getValue() - colOffset);
				}

				if (categoryBucket.getId() <= 2) {
					item.setPositionY(point.getY() - rowOffset);
				} else {
					item.setPositionY(point.getY() + rowOffset);
				}
				LOGGER.info("Item number {} is {} in {} for {}", itemCount, item.getBucketItemName(), itemStatus, categoryBucket.getBucketName());
				if ( ( itemCount % 2 ) == 0) {
					rowMap.put(itemStatus, rowOffset + offset + (data.getPadding() / 2.0));
				} else {
					colMap.put(itemStatus, colOffset + offset + (data.getPadding() / 2.0));
				}
				itemCount++;
			}
			data.getBuckets().put(categoryBucket.getBucketName(), categoryBucket);
		}
	}

	private void resetStatusByCategory(RadarData data, Integer offset, Map<String, Double> colMap, Map<String, Double> rowMap) {
		for (String status : data.getCircles().keySet()) {
			colMap.put(status, offset * 2.0);
			rowMap.put(status, offset * 2.0);
		}
	}

}
