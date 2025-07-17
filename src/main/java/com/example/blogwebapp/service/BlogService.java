package com.example.blogwebapp.service;

import com.example.blogwebapp.model.BlogPost;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class BlogService {

    private final List<BlogPost> posts = new ArrayList<>();
    private final AtomicLong counter = new AtomicLong();

    public List<BlogPost> getAllPosts() {
        return posts;
    }

    public BlogPost createPost(BlogPost post) {
        post.setId(counter.incrementAndGet());
        posts.add(post);
        return post;
    }
}
