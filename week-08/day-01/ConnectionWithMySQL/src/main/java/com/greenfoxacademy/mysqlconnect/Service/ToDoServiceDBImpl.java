package com.greenfoxacademy.mysqlconnect.Service;

import com.greenfoxacademy.mysqlconnect.Model.Todo;
import com.greenfoxacademy.mysqlconnect.Repository.ToDoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ToDoServiceDBImpl implements ToDoService {

    private final
    ToDoRepository toDoRepository;

    @Autowired
    public ToDoServiceDBImpl(ToDoRepository toDoRepository) {
        this.toDoRepository = toDoRepository;
    }

    @Override
    public List<Todo> getAllTodos() {
        List<Todo> toDos = new ArrayList<>();
        toDoRepository.findAll().forEach(toDos::add);
        return toDos;
    }

    @Override
    public Todo getToDo(long id) {
        return toDoRepository.findOne(id);
    }

    @Override
    public void editToDo(Todo todo) {
        toDoRepository.save(todo);
    }

    @Override
    public void save(Todo todo) {
        toDoRepository.save(todo);
    }

    @Override
    public void postpone(long id, String newDate) {
        Todo toDo = toDoRepository.findOne(id);
        toDo.setCreation_time(newDate);
        toDoRepository.save(toDo);
    }

    @Override
    public void delete(long id) {
        toDoRepository.delete(id);
    }

    @Override
    public List<Todo> findByDoneFalse() {
        List<Todo> toDos = new ArrayList<>();
        toDoRepository.findByDoneFalse().forEach(toDos::add);
        return toDos;
    }

    @Override
    public List<Todo> findByDoneTrue() {
        List<Todo> toDos = new ArrayList<>();
        toDoRepository.findByDoneTrue().forEach(toDos::add);
        return toDos;
    }

    @Override
    public Todo searchByTitle(String title) {
        return toDoRepository.findByTitle(title);
    }
}
