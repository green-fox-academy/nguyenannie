package com.greenfox.tamagochi.Service;

import com.greenfox.tamagochi.Model.Tamagochier;
import com.greenfox.tamagochi.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceDBImpl implements UserService{
    private final UserRepository userRepository;

    @Autowired
    public UserServiceDBImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<Tamagochier> getAllUsers() {
        List<Tamagochier> tamagochiers = new ArrayList<>();
        userRepository.findAll().forEach(tamagochiers::add);
        return tamagochiers;
    }

    @Override
    public Tamagochier getOneUser(String name) {
        return userRepository.findOne(name);
    }

    @Override
    public Tamagochier getByName(String name) {
        return userRepository.findOne(name);
    }

    @Override
    public void addNewUser(Tamagochier tamagochier) {
        userRepository.save(tamagochier);
    }

    @Override
    public boolean IsExisted(String username) {
        return userRepository.exists(username);
    }

}
