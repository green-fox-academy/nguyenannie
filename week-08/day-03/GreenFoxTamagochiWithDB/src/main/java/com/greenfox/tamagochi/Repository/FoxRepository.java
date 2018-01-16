package com.greenfox.tamagochi.Repository;

import com.greenfox.tamagochi.Model.Fox;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FoxRepository extends CrudRepository<Fox, String>{
    Fox findByName(String name);
}
