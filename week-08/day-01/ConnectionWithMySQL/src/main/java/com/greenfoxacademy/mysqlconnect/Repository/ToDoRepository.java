package com.greenfoxacademy.mysqlconnect.Repository;

import com.greenfoxacademy.mysqlconnect.Model.ToDo;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ToDoRepository extends CrudRepository<ToDo, Long> {
    List<ToDo> findByDoneFalse();
    List<ToDo> findByDoneTrue();
}
