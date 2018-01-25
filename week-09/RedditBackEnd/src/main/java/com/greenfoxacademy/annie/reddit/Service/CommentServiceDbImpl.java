package com.greenfoxacademy.annie.reddit.Service;

import com.greenfoxacademy.annie.reddit.Model.Entity.Comment;
import com.greenfoxacademy.annie.reddit.Repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentServiceDbImpl implements CommentService{
    private final CommentRepository commentRepository;

    @Autowired
    public CommentServiceDbImpl(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    @Override
    public void save(Comment comment) {
        commentRepository.save(comment);
    }

    @Override
    public void delete(long id) {
        commentRepository.delete(id);
    }
}
