package com.greenfox.tamagochi.Repository;

import com.greenfox.tamagochi.Model.Trick;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrickRepository extends CrudRepository<Trick, Long> {
}
