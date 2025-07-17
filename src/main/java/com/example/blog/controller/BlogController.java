package com.example.blog.controller;

import com.example.blog.service.DeleteService
import com.example.blog.model.Post;
import com.example.blog.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class BlogController {
    @Autowired
    private PostService postService;
    @Autowired
    private DeleteService deleteService;

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("posts", postService.getAllPosts());
        return "index";
    }

    @PostMapping("/delete/{id}")
    public String deletePost(@PathVariable Long id) {
        deleteService.deletePost(id);
        return "redirect:/";
    }

    @PostMapping("/api/posts/delete/{id}")
    @ResponseBody
    public void deletePostApi(@PathVariable Long id) {
        deleteService.deletePost(id);
    }

    @GetMapping("/create")
    public String createPostForm(Model model) {
        model.addAttribute("post", new Post());
        return "create-post";
    }

    @PostMapping("/create")
    public String createPost(@ModelAttribute Post post) {
        postService.createPost(post);
        return "redirect:/";
    }

    @GetMapping("/api/posts")
    @ResponseBody
    public List<Post> getAllPosts() {
        return postService.getAllPosts();
    }

    @GetMapping("/api/posts/{id}")
    @ResponseBody
    public Post getPostById(@PathVariable Long id) {
        return postService.getPostById(id).orElse(null);
    }

    @PostMapping("/api/posts")
    @ResponseBody
    public Post createPostApi(@RequestBody Post post) {
        return postService.createPost(post);
    }
}
