package com.example.blogwebapp.controller;

import com.example.blogwebapp.model.BlogPost;
import com.example.blogwebapp.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/posts")
public class BlogController {

    @Autowired
    private BlogService blogService;

    @GetMapping
    public List<BlogPost> getAllPosts() {
        return blogService.getAllPosts();
    }

    @PostMapping
    public BlogPost createPost(@RequestBody BlogPost post) {
        return blogService.createPost(post);
    }
}
