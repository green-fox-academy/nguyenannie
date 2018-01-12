package com.spring.playwithjpa.Repository;

import com.spring.playwithjpa.Entity.AnnieHouseMember;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AnnieHomeRepository extends CrudRepository<AnnieHouseMember, Long> {
    List<AnnieHouseMember> findByLastName(String lastName);
}
