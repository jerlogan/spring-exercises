package com.codeup.blog.Controllers;

import com.codeup.blog.services.SportRepository;
import com.codeup.blog.services.TeamRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SportController {
    private SportRepository sportRepository;

    public SportController(SportRepository sportRepository) {
        this.sportRepository = sportRepository;
    }

    @GetMapping("/sports")
    public String getUsers(Model model) {
        model.addAttribute("allSports", sportRepository.findAll());

        return "sports/index";
    }
}
