package com.greenfoxacademy.finderapp.controller.service;

import com.greenfoxacademy.finderapp.controller.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.greenfoxacademy.finderapp.controller.repository.UserRepository;

import java.util.List;

@Service
public class UserService {
    private final
    UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getAll() {
        return userRepository.getAll();
    }

    public void save(User user) {
        userRepository.save(user);
    }
}
