package com.alacritysys.apps.oss.radar.data;

import java.io.Serializable;

import org.springframework.data.geo.Circle;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class RadarCircle implements Serializable {
	
	private static final long serialVersionUID = 7518356371462250065L;

	private String name;
	private Circle circle;
	private Double border;
}
