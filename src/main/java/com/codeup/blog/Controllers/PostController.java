package com.codeup.blog.Controllers;

import com.codeup.blog.models.Post;
import com.codeup.blog.services.PostRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;

@Controller
public class PostController {

    private final PostRepository postDao;

    public PostController (PostRepository postDao) {
        this.postDao = postDao;
    }


    @GetMapping("/posts")
    public String allPosts(Model model) {

        model.addAttribute("allPosts", postDao.findAll());

//      TEMPORARY SEEDER FOR TWO POSTS


//        ArrayList<Post> allPosts = new ArrayList<>();
//
//        Post hockeyPost = new Post("Avs seeking revenge against hungry Sharks", "The Avs and Sharks will play a critical game 4 Wednesday night at Pepsi Center.");
//        Post footballPost = new Post("Raiders surprise many as draft comes to a close", "Mike Mayock and John Gruden decided on Clemson's Clelin Ferrel as their top choice in the draft.");
//
//        allPosts.add(hockeyPost);
//        allPosts.add(footballPost);
//
//        model.addAttribute("allPosts", allPosts);



        return "posts/index";
    }

    @GetMapping("/posts/{id}")
    public String specificPost(@PathVariable long id, Model model) {
        model.addAttribute("id", id);
        Post post = new Post("Title", "This is a brief description.");
        model.addAttribute("post", post);
        return "posts/show";
    }

    @GetMapping("/posts/create")
    @ResponseBody
    public String viewCreatePost() {
        return "Create a post here.";
    }

    @PostMapping("/posts/create")
    @ResponseBody
    public String createPost() {
        return "Create a post here.";
    }


}
