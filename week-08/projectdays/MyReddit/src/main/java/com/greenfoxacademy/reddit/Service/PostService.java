package com.greenfoxacademy.reddit.Service;

import com.greenfoxacademy.reddit.Model.Post;
import org.springframework.stereotype.Service;

@Service
public interface PostService {
    void save(Post post);
}
