package com.greenfoxacademy.reddit.Service;

import com.greenfoxacademy.reddit.Model.Post;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PostService {
    void save(Post post);
    List<Post> findAll();
    Post findOne(long id);
}
