package com.greenfoxacademy.annie.reddit.Repository;

import com.greenfoxacademy.annie.reddit.Model.Entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Long>{
    User findByName(String username);
}
