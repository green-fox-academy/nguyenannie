package com.greenfoxacademy.annie.reddit.Service;

import com.greenfoxacademy.annie.reddit.Entity.Post;
import com.greenfoxacademy.annie.reddit.Entity.User;
import com.greenfoxacademy.annie.reddit.Entity.Vote;
import com.greenfoxacademy.annie.reddit.Repository.VoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VoteServiceDbImpl implements VoteService{
    private final VoteRepository voteRepository;

    @Autowired
    public VoteServiceDbImpl(VoteRepository voteRepository) {
        this.voteRepository = voteRepository;
    }

    @Override
    public Vote findByPostAndUser(Post post, User user) {
        return voteRepository.findByPostAndUser(post, user);
    }

    @Override
    public void save(Vote vote) {
        voteRepository.save(vote);
    }

    @Override
    public void delete(Vote vote) {
        long id = vote.getId();
        voteRepository.delete(id);
    }
}
