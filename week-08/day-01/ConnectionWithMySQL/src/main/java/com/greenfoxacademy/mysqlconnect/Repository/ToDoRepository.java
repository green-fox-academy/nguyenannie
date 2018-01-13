package com.greenfoxacademy.mysqlconnect.Repository;

import com.greenfoxacademy.mysqlconnect.Model.ToDo;
import org.springframework.data.repository.CrudRepository;

public interface ToDoRepository extends CrudRepository<ToDo, Long> {
}
