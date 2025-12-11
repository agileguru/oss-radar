package com.alacritysys.apps.oss.radar.health;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.web.servlet.client.RestTestClient;

import com.alacritysys.apps.oss.radar.ApplicationConstants;
import com.alacritysys.apps.oss.radar.RadarApplication;

@SpringBootTest(webEnvironment = WebEnvironment.DEFINED_PORT, classes = RadarApplication.class)
class HealthAndReadinessCheckTest {

	@Value("${server.port}")
	private int port; 

	@Value("${server.servlet.context-path}")
	private String contextPath;

	private RestTestClient restTestClient;
	
	@BeforeEach
	void setUp() {
		if ( restTestClient != null ) return;
		restTestClient = RestTestClient.bindToServer().baseUrl( "http://localhost:" + port + contextPath).build();
	}

	@Test
	void testActuatorURIDoesnotThrowError() {
		restTestClient.get().uri(ApplicationConstants.URI_MAPPING_ACTUATOR_HEALTH)
		.exchange().expectStatus().isOk();
	}

}
