package com.greenfoxacademy.mysqlconnect.Service;

import com.greenfoxacademy.mysqlconnect.Model.Assignee;
import com.greenfoxacademy.mysqlconnect.Model.Todo;
import com.greenfoxacademy.mysqlconnect.Repository.AssigneeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AssigneeServiceDBImpl implements AssigneeService{

    private final
    AssigneeRepository assigneeRepository;

    @Autowired
    public AssigneeServiceDBImpl(AssigneeRepository assigneeRepository) {
        this.assigneeRepository = assigneeRepository;
    }


    @Override
    public List<Assignee> getAllAssignees() {
        List<Assignee> assignees = new ArrayList<>();
        assigneeRepository.findAll().forEach(assignees::add);
        return assignees;
    }

    @Override
    public Assignee getAssignee(long id) {
        return assigneeRepository.findOne(id);
    }

    @Override
    public void editAssignee(Assignee assignee) {
        assigneeRepository.save(assignee);
    }

    @Override
    public void save(Assignee assignee) {
        assigneeRepository.save(assignee);
    }

    @Override
    public void delete(long id) {
        assigneeRepository.delete(id);
    }

    @Override
    public List<Assignee> findByName(String name) {
        return assigneeRepository.findByName(name);
    }

    @Override
    public List<Assignee> findByEmail(String email) {
        return assigneeRepository.findByEmail(email);
    }
}
