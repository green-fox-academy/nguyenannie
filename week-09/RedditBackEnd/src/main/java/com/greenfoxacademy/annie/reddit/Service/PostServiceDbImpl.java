package com.greenfoxacademy.annie.reddit.Service;

import com.greenfoxacademy.annie.reddit.Model.Post;
import com.greenfoxacademy.annie.reddit.Repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PostServiceDbImpl implements PostService{
    private final PostRepository postRepository;

    @Autowired
    public PostServiceDbImpl(PostRepository postRepository) {
        this.postRepository = postRepository;
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

    @Override
    public Page<Post> findByPage(Pageable pageable) {
        return postRepository.findAll(pageable);
    }

    @Override
    public void save(Post post) {
        postRepository.save(post);
    }
}
