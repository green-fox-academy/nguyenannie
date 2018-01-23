package com.greenfoxacademy.annie.reddit.Repository;

import com.greenfoxacademy.annie.reddit.Model.Comment;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentRepository extends CrudRepository<Comment, Long>{
}
