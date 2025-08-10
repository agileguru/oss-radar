package com.alacritysys.apps.oss.radar;

public abstract class ApplicationConstants {

	private ApplicationConstants() {
		
	}
	public static final String RADAR_VIEW = "home";
	public static final String RADAR_MOBILE_VIEW = "mobile";
	
	public static final String DATA = "data";
	public static final String RADAR_MAPPING = "";
	public static final String RADAR_MOBILE_MAPPING = "/mobile";
	
	public static final String URI_MAPPING_API_PREFIX = "/api";
	public static final String URI_MAPPING_API_SWAGGER_PATH_SPEC = URI_MAPPING_API_PREFIX + ".*";
	public static final String URI_MAPPING_GET_ALL_BUCKETS = URI_MAPPING_API_PREFIX + "/buckets";
	public static final String URI_MAPPING_ACTUATOR_HEALTH = "/actuator/health";
	
	
	public static final String JPA_MAPPING_CATEGORY_TABLE_NAME = "category";
	public static final String JPA_MAPPPING_ITEM_TABLE_NAME = "item";
	public static final String JPA_MAPPPING_ITEM_TABLE_CATEGORY_ID_COLUMN_NAME = "category";
	
	
	public static final String ITEM_STATUS_ADOPT = "Adopt";
	public static final String ITEM_STATUS_TRIAL = "Trial";
	public static final String ITEM_STATUS_ASSESS = "Assess";
	public static final String ITEM_STATUS_HOLD = "Hold";
	
	public static final String CONFIG_RADAR_WIDTH = "${radar.width:600}";
	public static final String CONFIG_RADAR_OFFSET = "${radar.offset:5}";
	
	public static final String CONFIG_RADAR_TILES_DEFN_MAPPING = "WEB-INF/tiles/tiles.xml";
	
}
