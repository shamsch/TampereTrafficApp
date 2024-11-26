package fi.tuni.TampereTrafficApp.controllers;

import org.springframework.stereotype.Controller;

@Controller("/")
public class HomeController {

    public String index() {
        return "index";
    }
}
