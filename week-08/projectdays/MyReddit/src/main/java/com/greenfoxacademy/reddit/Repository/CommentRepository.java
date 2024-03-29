package com.greenfoxacademy.reddit.Repository;

import com.greenfoxacademy.reddit.Model.Comment;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentRepository extends CrudRepository<Comment, Long> {
}
