package com.greenfoxacademy.annie.reddit.Service;

import com.greenfoxacademy.annie.reddit.Model.User;
import com.greenfoxacademy.annie.reddit.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceDbImpl implements UserService{
    private final UserRepository userRepository;

    @Autowired
    public UserServiceDbImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User findOne(long id) {
        return userRepository.findOne(id);
    }

    @Override
    public User findByName(String username) {
        return userRepository.findByName(username);
    }

    @Override
    public void save(User user) {
        userRepository.save(user);
    }
}
