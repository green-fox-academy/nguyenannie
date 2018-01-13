package com.greenfoxacademy.listingtodo.Repository;

import com.greenfoxacademy.listingtodo.Entity.ToDo;
import org.springframework.data.repository.CrudRepository;

public interface ToDoRepository extends CrudRepository<ToDo, Long> {
}
