package com.greenfoxacademy.classapp.Service;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService {
    ArrayList<String> names;
    private int counter;
    private boolean inList;

    public StudentService() {
        names = new ArrayList<>();
        names.add("Sanyi");
        names.add("Lilla");
        names.add("John");
    }

    public List<String> findAll() {
        return names;
    }

    public void save(String student) {
        names.add(student);
    }

    public void count() {
        counter = names.size();
    }

    public ArrayList<String> getNames() {
        return names;
    }

    public int getCounter() {
        return counter;
    }

    public boolean isInList() {
        return inList;
    }

    public boolean getInList() {
        return inList;
    }

    public void checkName(String studentname) {
        if(names.contains(studentname)) {
            inList = true;
        } else {
            inList = false;
        }
    }
}
