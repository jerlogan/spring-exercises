package com.codeup.blog.Controllers;

import com.codeup.blog.models.Post;
import com.codeup.blog.models.Sport;
import com.codeup.blog.models.Team;
import com.codeup.blog.models.User;
import com.codeup.blog.services.PostRepository;
import com.codeup.blog.services.SportRepository;
import com.codeup.blog.services.TeamRepository;
import com.codeup.blog.services.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
public class PostController {

    private PostRepository postRepository;
    private UserRepository userRepository;
    private TeamRepository teamRepository;
    private SportRepository sportRepository;

    public PostController(PostRepository postRepository, UserRepository userRepository, TeamRepository teamRepository, SportRepository sportRepository) {
        this.postRepository = postRepository;
        this.userRepository = userRepository;
        this.teamRepository = teamRepository;
        this.sportRepository = sportRepository;
    }



    @GetMapping("/posts")
    public String allPosts(Model model) {
        model.addAttribute("allPosts", postRepository.findAll());

        return "posts/index";
    }

//
//      Specific post

    @GetMapping("/posts/{id}")
    public String specificPost(@PathVariable long id, Model model) {
        Post post = postRepository.findOne(id);
        model.addAttribute("post", post);
        return "posts/show";
    }

    @GetMapping("/posts/create")
    public String viewCreatePost(Model model) {
        model.addAttribute("allTeams", teamRepository.findAll());
        model.addAttribute("allSports", sportRepository.findAll());
        model.addAttribute("allSports", sportRepository.findAll());
        model.addAttribute("post", new Post());
        return "posts/create";
    }

    @PostMapping("/posts/create")
    public String createPost(
            @RequestParam(name = "title") String title,
            @RequestParam(name = "body") String body,
            @RequestParam(name = "team") String team,
            @RequestParam(name = "sport") Sport sport) {
        Post post = new Post();
        post.setTitle(title);
        post.setBody(body);


//        teamRepository.searchTeamByTeamName(team);
        post.setSport(sport);

        System.out.println(team);
        System.out.println(sport);

        postRepository.save(post);
        return "posts/index";
    }
}


