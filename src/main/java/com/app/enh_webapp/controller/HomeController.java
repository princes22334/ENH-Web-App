package com.app.enh_webapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

//    @RequestMapping(value = "/", method = RequestMethod.GET)
//    public RedirectView redirectToSwagger() {
//        return new RedirectView("/swagger-ui/index.html");
//    }
@Controller
public class HomeController {

    @RequestMapping("")
    public String homePage() {
        return "index";
    }

    @GetMapping("/")
    public String serveHomePage() {
        return "home=page";
    }
}

