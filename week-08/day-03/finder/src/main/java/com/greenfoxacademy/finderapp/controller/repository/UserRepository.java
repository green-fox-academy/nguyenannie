package com.greenfoxacademy.finderapp.controller.repository;

import com.greenfoxacademy.finderapp.controller.model.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRepository{
    private List<User> users = new ArrayList<>();

    UserRepository() {

    }

    public List<User> getAll() {
        return users;
    }

    public void save(User user) {
        users.add(user);
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}
