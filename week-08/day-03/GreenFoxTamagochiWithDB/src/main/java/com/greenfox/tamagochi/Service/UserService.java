package com.greenfox.tamagochi.Service;

import com.greenfox.tamagochi.Model.Tamagochier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    List<Tamagochier> getAllUsers();
    Tamagochier getOneUser(long id);
    Tamagochier getOneUserByName(String name);
    void addNewUser(Tamagochier tamagochier);
    boolean IsExisted(String name);

}
