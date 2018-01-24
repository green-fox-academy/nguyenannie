package com.greenfoxacademy.restexercise.Service;

import com.greenfoxacademy.restexercise.Model.Log;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface LogService {
    void save(Log log);
    List<Log> findAll();
    Page<Log> findByPage(Pageable pageable);
}
