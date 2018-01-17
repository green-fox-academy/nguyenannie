package com.greenfoxacademy.reddit.Repository;

import com.greenfoxacademy.reddit.Model.Post;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends CrudRepository<Post, Long> {
}
