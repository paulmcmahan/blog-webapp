package com.example.blog.service;

import com.example.blog.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeleteService {
    @Autowired
    private PostRepository postRepository;

    public void deletePost(Long id) {
        postRepository.deleteById(id);
    }
}
