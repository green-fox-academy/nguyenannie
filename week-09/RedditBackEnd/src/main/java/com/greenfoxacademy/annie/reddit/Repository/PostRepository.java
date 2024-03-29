package com.greenfoxacademy.annie.reddit.Repository;

import com.greenfoxacademy.annie.reddit.Entity.Post;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends PagingAndSortingRepository<Post, Long> {
}
