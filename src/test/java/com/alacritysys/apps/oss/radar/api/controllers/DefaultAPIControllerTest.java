package com.alacritysys.apps.oss.radar.api.controllers;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;

@SpringBootTest
class DefaultAPIControllerTest {

	
	@Autowired
	private DefaultAPIController controller;
	
	@Test
	void testControllerNotNull() {
		assertThat(this.controller).isNotNull();
	}

	@Test
	void testControllerHome() {
		ResponseEntity<String> apiHome = this.controller.apiHome();
		assertThat(apiHome.getStatusCode()).isNotNull().isEqualTo(HttpStatusCode.valueOf(200));
	}


}
