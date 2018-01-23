package com.greenfoxacademy.annie.reddit.Service;

import com.greenfoxacademy.annie.reddit.Model.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PostService {
    List<Post> findAll();
    Post findOne(long id);
    Page<Post> findByPage(Pageable pageable);
    void save(Post post);
}
