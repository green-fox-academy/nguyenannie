package com.greenfoxacademy.mysqlconnect.Service;

import com.greenfoxacademy.mysqlconnect.Model.Assignee;
import com.greenfoxacademy.mysqlconnect.Model.Todo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ToDoService {
    List<Todo> getAllTodos();
    Todo getToDo(long id);
    void editToDo(Todo todo);
    void save(Todo todo);
    void postpone(long id, String newDate);
    void delete(long id);
    List<Todo> findByDoneFalse();
    List<Todo> findByDoneTrue();
    Todo searchByTitle(String title);
    List<Todo> searchByCreationtime(String creationTime);
    List<Todo> searchByAssignee(Assignee assignee);
    List<Todo> searchByDuedate(String dueDate);
}
