package com.greenfoxacademy.reddit.Service;

import com.greenfoxacademy.reddit.Model.Post;
import com.greenfoxacademy.reddit.Repository.PostRepository;
import javafx.geometry.Pos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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

    @Override
    public List<Post> findAll() {
        List<Post> posts = new ArrayList<>();
        postRepository.findAll().forEach(posts::add);
        return posts;
    }

    @Override
    public Post findOne(long id) {
        return postRepository.findOne(id);
    }
}
