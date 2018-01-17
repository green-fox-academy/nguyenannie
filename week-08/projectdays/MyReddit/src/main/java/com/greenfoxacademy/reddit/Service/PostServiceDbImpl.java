package com.greenfoxacademy.reddit.Service;

import com.greenfoxacademy.reddit.Model.Post;
import com.greenfoxacademy.reddit.Repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostServiceDbImpl implements PostService {
    private final PostRepository postRepository;

    @Autowired
    public PostServiceDbImpl(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Override
    public void save(Post post) {
        postRepository.save(post);
    }
}
