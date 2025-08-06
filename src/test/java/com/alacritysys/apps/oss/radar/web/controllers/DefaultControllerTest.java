package com.alacritysys.apps.oss.radar.web.controllers;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.servlet.view.RedirectView;

@SpringBootTest
class DefaultControllerTest {

    @Autowired
	private DefaultController controller;
	
	@Test
	void testControllerNotNull() {
		assertThat(this.controller).isNotNull();
	}

	@Test
	void testControllerHome() {
		RedirectView apiHome = this.controller.home();
		assertThat(apiHome.getUrl()).isNotNull().isEqualTo("/api");
	}
}
