package com.greenfoxacademy.annie.p2pchatapp.Repository;

import com.greenfoxacademy.annie.p2pchatapp.Model.Appmessage;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MessageRepository extends CrudRepository<Appmessage, Long>{
}
