package com.greenfoxacademy.annie.p2pchatapp.Repository;

import com.greenfoxacademy.annie.p2pchatapp.Model.Appuser;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppuserRepository extends CrudRepository<Appuser, Long> {
    Appuser findByUsername(String name);
}
