package com.alacritysys.apps.oss.radar.data;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class RadarData implements Serializable{
	private static final long serialVersionUID = 1295863982413048521L;
	private Integer viewWidth = 0;
	private Integer totalCircles = 0;
	private Map<String,RadarCircle> circles = new LinkedHashMap<>();
	private Map<String,CategoryBucket> buckets = new LinkedHashMap<>();
	private Integer padding = 0;
	
}
