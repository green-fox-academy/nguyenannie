package com.greenfoxacademy.mysqlconnect.Service;

import com.greenfoxacademy.mysqlconnect.Model.Assignee;
import com.greenfoxacademy.mysqlconnect.Model.Todo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ToDoFileService implements ToDoService {
    @Override
    public List<Todo> getAllTodos() {
        return null;
    }

    @Override
    public Todo getToDo(long id) {
        return null;
    }

    @Override
    public void editToDo(Todo todo) {

    }

    @Override
    public void save(Todo todo) {

    }

    @Override
    public void postpone(long id, String newDate) {

    }

    @Override
    public void delete(long id) {

    }

    @Override
    public List<Todo> findByDoneFalse() {
        return null;
    }

    @Override
    public List<Todo> findByDoneTrue() {
        return null;
    }

    @Override
    public Todo searchByTitle(String title) {
        return null;
    }

    @Override
    public List<Todo> searchByCreationtime(String creationTime) {
        return null;
    }

    @Override
    public List<Todo> searchByAssignee(Assignee assignee) {
        return null;
    }

    @Override
    public List<Todo> searchByDuedate(String dueDate) {
        return null;
    }
}
