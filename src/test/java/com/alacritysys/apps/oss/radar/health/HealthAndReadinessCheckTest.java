package com.alacritysys.apps.oss.radar.health;

import static io.restassured.RestAssured.given;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.HttpStatus;

import com.alacritysys.apps.oss.radar.ApplicationConstants;
import com.alacritysys.apps.oss.radar.RadarApplication;

import io.restassured.RestAssured;

@SpringBootTest(webEnvironment = WebEnvironment.DEFINED_PORT, classes = RadarApplication.class)
class HealthAndReadinessCheckTest {

	@Value("${server.port}")
	private int port; 
	
	@Value("${server.servlet.context-path}")
	private String contextPath;
	
	@BeforeEach
	void setUp() {
		RestAssured.baseURI = "http://localhost:" + port;
		RestAssured.basePath = contextPath;
	}

	@Test
	void testActuatorURIDoesnotThrowError() {
		given()
			.get(ApplicationConstants.URI_MAPPING_ACTUATOR_HEALTH)
		.then()
			.statusCode(HttpStatus.OK.value());
	}

}
