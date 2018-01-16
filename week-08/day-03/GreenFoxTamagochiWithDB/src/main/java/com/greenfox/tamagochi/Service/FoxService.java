package com.greenfox.tamagochi.Service;

import com.greenfox.tamagochi.Model.Fox;
import org.springframework.stereotype.Service;

@Service
public interface FoxService {
    void addNewFox(Fox fox);
    Fox searchByName(String name);
    void save(Fox fox);
}
