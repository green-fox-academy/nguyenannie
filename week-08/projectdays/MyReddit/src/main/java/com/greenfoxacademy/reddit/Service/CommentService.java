package com.greenfoxacademy.reddit.Service;

import com.greenfoxacademy.reddit.Model.Comment;
import org.springframework.stereotype.Service;

@Service
public interface CommentService {
    void save(Comment comment);
}

