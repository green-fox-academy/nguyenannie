package com.greenfoxacademy.annie.reddit.Service;

import com.greenfoxacademy.annie.reddit.Model.Entity.User;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    User findOne(long id);
    User findByName(String username);
    void save(User user);
}
