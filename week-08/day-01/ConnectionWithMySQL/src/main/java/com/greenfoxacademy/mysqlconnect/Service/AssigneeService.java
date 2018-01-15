package com.greenfoxacademy.mysqlconnect.Service;

import com.greenfoxacademy.mysqlconnect.Model.Assignee;
import com.greenfoxacademy.mysqlconnect.Model.Todo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AssigneeService {
    List<Assignee> getAllAssignees();
    Assignee getAssignee(long id);
    void editAssignee(Assignee assignee);
    void save(Assignee assignee);
    void delete(long id);
    List<Assignee> findByName(String name);
    List<Assignee> findByEmail(String email);
}
