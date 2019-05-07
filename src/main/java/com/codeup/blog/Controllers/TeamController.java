package com.codeup.blog.Controllers;

import com.codeup.blog.services.TeamRepository;
import com.codeup.blog.services.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TeamController {
    private TeamRepository teamRepository;

    public TeamController(TeamRepository teamRepository) {
        this.teamRepository = teamRepository;
    }

    @GetMapping("/teams")
    public String getUsers(Model model) {
        model.addAttribute("allTeams", teamRepository.findAll());

        return "teams/index";
    }
}
