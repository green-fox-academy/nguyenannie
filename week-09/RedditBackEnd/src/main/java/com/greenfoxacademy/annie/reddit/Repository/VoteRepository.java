package com.greenfoxacademy.annie.reddit.Repository;

import com.greenfoxacademy.annie.reddit.Model.Post;
import com.greenfoxacademy.annie.reddit.Model.User;
import com.greenfoxacademy.annie.reddit.Model.Vote;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VoteRepository extends CrudRepository<Vote, Long>{
    Vote findByPostAndUser(Post post, User user);
}
