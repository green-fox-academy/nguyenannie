package com.greenfoxacademy.annie.reddit.Service;

import com.greenfoxacademy.annie.reddit.Model.Entity.Post;
import com.greenfoxacademy.annie.reddit.Model.Entity.User;
import com.greenfoxacademy.annie.reddit.Model.Entity.Vote;
import org.springframework.stereotype.Service;

@Service
public interface VoteService {
    Vote findByPostAndUser(Post post, User user);
    void save(Vote vote);
    void delete(Vote vote);
}
