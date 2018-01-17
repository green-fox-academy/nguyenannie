package com.greenfox.tamagochi.Service;

import com.greenfox.tamagochi.Model.Trick;

import java.util.List;

public interface TrickService {
    void addNewTrick(Trick newTrick);
    Trick searchOneByName(String name);
    List<Trick> getAllTricks();
}
