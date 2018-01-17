package com.greenfox.tamagochi.Service;

import com.greenfox.tamagochi.Model.Fox;
import org.springframework.stereotype.Service;

@Service
public interface FoxService {
    void addNewFox(Fox fox);
    void updateFox(Fox fox);
    Fox searchOneByName(String name);
    Fox searchOneById(long id);
    void save(Fox fox);
}
