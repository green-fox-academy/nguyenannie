package com.greenfoxacademy.restexercise.Model.LogEndpoint;

import com.greenfoxacademy.restexercise.Service.LogServiceDbImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
public class LogResponse {
    private final LogServiceDbImpl logServiceDb;

    private List<Log> entries;
    private int entry_count;

    @Autowired
    public LogResponse(LogServiceDbImpl logServiceDb) {
        entries = logServiceDb.findAll();
        entry_count = getEntries().size();
        this.logServiceDb = logServiceDb;
    }

    public List<Log> getEntries() {
        return entries;
    }

    public void setEntries(List<Log> entries) {
        this.entries = entries;
    }

    public int getEntry_count() {
        return entry_count;
    }

    public void setEntry_count(int entry_count) {
        this.entry_count = entry_count;
    }
}
