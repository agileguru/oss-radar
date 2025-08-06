package com.alacritysys.apps.oss.radar.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.view.RedirectView;


@Controller
public class DefaultController {

    @GetMapping("")
    public RedirectView home() {
        return new RedirectView("/api", true);
    }
    
}
