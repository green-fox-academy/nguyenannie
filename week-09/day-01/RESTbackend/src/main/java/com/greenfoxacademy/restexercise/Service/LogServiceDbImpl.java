package com.greenfoxacademy.restexercise.Service;

import com.greenfoxacademy.restexercise.Model.Log;
import com.greenfoxacademy.restexercise.Repository.LogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LogServiceDbImpl implements LogService{
    private final LogRepository logRepository;

    @Autowired
    public LogServiceDbImpl(LogRepository logRepository) {
        this.logRepository = logRepository;
    }

    @Override
    public void save(Log log) {
        logRepository.save(log);
    }

    @Override
    public List<Log> findAll() {
        List<Log> logs = new ArrayList<>();
        logRepository.findAll().forEach(logs::add);
        return logs;
    }
}
