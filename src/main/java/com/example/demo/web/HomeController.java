package com.example.demo.web;

import com.example.demo.security.CurrentUser;
import com.example.demo.service.HeroService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    private final CurrentUser currentUser;
    private final HeroService heroService;


    public HomeController(CurrentUser currentUser, HeroService heroService) {
        this.currentUser = currentUser;
        this.heroService = heroService;
    }

    @GetMapping("/")
    public String home(Model model){

        if (currentUser.isAnonymous()){
            return "index";
        }
        model.addAttribute("heroes", this.heroService.findAll());
        return "home";
    }
}
