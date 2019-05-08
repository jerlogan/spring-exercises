package com.codeup.blog.Controllers;

import com.codeup.blog.models.Post;
import com.codeup.blog.models.Sport;
import com.codeup.blog.models.Team;
import com.codeup.blog.models.User;
import com.codeup.blog.services.*;
import org.hibernate.validator.constraints.Email;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
public class PostController {

    private PostRepository postRepository;
    private UserRepository userRepository;
    private TeamRepository teamRepository;
    private SportRepository sportRepository;
    private EmailService emailService;

    public PostController(PostRepository postRepository, UserRepository userRepository, TeamRepository teamRepository, SportRepository sportRepository, EmailService emailService) {
        this.postRepository = postRepository;
        this.userRepository = userRepository;
        this.teamRepository = teamRepository;
        this.sportRepository = sportRepository;
        this.emailService = emailService;
    }

    //    -----------------------------------------------------------------------
//    view all posts
//    -----------------------------------------------------------------------

    @GetMapping("/posts")
    public String allPosts(Model model) {
        model.addAttribute("allPosts", postRepository.findAll());
        return "posts/index";
    }

//
//    -----------------------------------------------------------------------
//    view post
//    -----------------------------------------------------------------------

    @GetMapping("/posts/{id}")
    public String specificPost(@PathVariable long id, Model model) {
        Post post = postRepository.findOne(id);
        model.addAttribute("post", post);
        return "posts/show";
    }


//    -----------------------------------------------------------------------
//    edit post
//    -----------------------------------------------------------------------

    @GetMapping("/posts/{id}/edit")
    public String editThisPost(@PathVariable long id, Model model) {
        model.addAttribute("allTeams", teamRepository.findAll());
        model.addAttribute("allSports", sportRepository.findAll());

        Post post = postRepository.findOne(id);
        model.addAttribute("post", post);

        return "posts/edit";
    }

    @PostMapping("/posts/{id}/edit")
    public String editThisPost(
            Model model,
            @PathVariable(name = "id") long id,
            @RequestParam(name = "title") String title,
            @RequestParam(name = "body") String body,
            @RequestParam(name = "team") String teamIDString,
            @RequestParam(name = "sport") String sportIDString) {


//        Locate the post by ID

        Post post = postRepository.findOne(id);


//        change our id strings into longs

        long teamID = Long.parseLong(teamIDString);
        long sportID = Long.parseLong(sportIDString);


//        Make changes to post

        post.setTitle(title);
        post.setBody(body);
        post.setSport(sportRepository.findOne(sportID));
        post.setTeam(teamRepository.findOne(teamID));


        postRepository.save(post);

//        Return page after edit

        Post editedPost = postRepository.findOne(post.getId());
        model.addAttribute("editedPost", editedPost);

        return "posts/edit-success";
    }


//    -----------------------------------------------------------------------
//    create post
//    -----------------------------------------------------------------------


    @GetMapping("/posts/create")
    public String viewCreatePost(Model model) {
        model.addAttribute("allTeams", teamRepository.findAll());
        model.addAttribute("allSports", sportRepository.findAll());
        model.addAttribute("post", new Post());
        return "posts/create";
    }

    @PostMapping("/posts/create")
    public String createPost(
            Model model,
            @RequestParam(name = "title") String title,
            @RequestParam(name = "body") String body,
            @RequestParam(name = "team") String teamIDString,
            @RequestParam(name = "sport") String sportIDString) {


//        Quickly change strings to longs for team and sport IDs

        long teamID = Long.parseLong(teamIDString);
        long sportID = Long.parseLong(sportIDString);

        Team thisTeam = teamRepository.findOne(teamID);
        Sport thisSport = sportRepository.findOne(sportID);


//        Now it's time to actually make the post.

        Post post = new Post();
        post.setTitle(title);
        post.setBody(body);
        post.setSport(thisSport);
        post.setTeam(thisTeam);

        postRepository.save(post);

//        After post is created, give user options to do something next

        Post createdPost = postRepository.findOne(post.getId());
        model.addAttribute("createdPost", createdPost);


//        Send email commented out for now so I don't send an email every time

//        emailService.prepareAndSend(post, "Congratulations James! You have been hired for this position", "You have been hired for this position: 1007A McDonalds Region Manager");

        return "posts/create-success";
    }



//    -----------------------------------------------------------------------
//    delete
//    -----------------------------------------------------------------------

    @GetMapping("/posts/{id}/delete-prompt")
    public String viewDeletePost(@PathVariable long id, Model model) {
        Post post = postRepository.findOne(id);
//        postRepository.delete(post);
        model.addAttribute("post", post);

        return "posts/delete-prompt";
    }









//    -----------------------------------------------------------------------
//    email
//    -----------------------------------------------------------------------


}


