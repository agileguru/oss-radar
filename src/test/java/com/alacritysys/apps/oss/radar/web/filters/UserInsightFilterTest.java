package com.alacritysys.apps.oss.radar.web.filters;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.web.servlet.client.RestTestClient;

import com.alacritysys.apps.oss.radar.ApplicationConstants;
import com.alacritysys.apps.oss.radar.RadarApplication;

@SpringBootTest(webEnvironment = WebEnvironment.DEFINED_PORT, classes = RadarApplication.class)
class UserInsightFilterTest {

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
	void testLogChangesOnDebugParam() {
		restTestClient.get().uri(uriBuilder -> uriBuilder.path("/").queryParam("debug", "on").build()).exchange().expectStatus()
				.isOk();
	}

	@Test
	void testNoLogChangesOnMissingDebugParam() {
		restTestClient.get().uri(ApplicationConstants.URI_MAPPING_GET_ALL_BUCKETS)
				.exchange().expectStatus().isOk();
	}

}
