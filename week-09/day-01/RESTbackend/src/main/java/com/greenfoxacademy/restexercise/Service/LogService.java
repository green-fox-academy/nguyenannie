package com.greenfoxacademy.restexercise.Service;

import com.greenfoxacademy.restexercise.Model.Log;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface LogService {
    void save(Log log);
    List<Log> findAll();
}
