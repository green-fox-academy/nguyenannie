package com.greenfoxacademy.mysqlconnect.Repository;

import com.greenfoxacademy.mysqlconnect.Model.Assignee;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AssigneeRepository extends CrudRepository<Assignee, Long> {
    List<Assignee> findByName(String name);
    List<Assignee> findByEmail(String email);
}
