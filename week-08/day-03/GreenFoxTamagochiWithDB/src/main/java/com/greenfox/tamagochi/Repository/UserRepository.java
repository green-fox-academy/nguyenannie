package com.greenfox.tamagochi.Repository;

import com.greenfox.tamagochi.Model.Tamagochier;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<Tamagochier, Long>{
    Tamagochier findByName(String name);
}
