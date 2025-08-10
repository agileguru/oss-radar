package com.alacritysys.apps.oss.radar.web.filters;

import static io.restassured.RestAssured.given;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.HttpStatus;

import com.alacritysys.apps.oss.radar.ApplicationConstants;
import com.alacritysys.apps.oss.radar.RadarApplication;

import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.ResponseSpecification;

@SpringBootTest(webEnvironment = WebEnvironment.DEFINED_PORT, classes = RadarApplication.class)
class UserInsightFilterTest {

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
	void testSetUp() {
		assertThat(this.port).isNotZero();
		assertThat(this.contextPath).isNotNull().isNotBlank();
	}

	@Test
	void testLogChangesOnDebugParam() {
		ResponseSpecification statusCode = given().queryParam("debug", "on").then().statusCode(HttpStatus.OK.value());
		assertThat(statusCode).isNotNull();
	}

	@Test
	void testNoLogChangesOnMissingDebugParam() {
		ValidatableResponse statusCode = given().get(ApplicationConstants.URI_MAPPING_GET_ALL_BUCKETS).then().statusCode(HttpStatus.OK.value());
		assertThat(statusCode).isNotNull();
	}

}
