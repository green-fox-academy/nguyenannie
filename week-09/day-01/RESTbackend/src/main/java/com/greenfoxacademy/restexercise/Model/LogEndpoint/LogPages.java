package com.greenfoxacademy.restexercise.Model.LogEndpoint;

import com.greenfoxacademy.restexercise.Service.LogServiceDbImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

@Component
public class LogPages {

    private Page<Log> entries;
    private long entry_count;

    public LogPages(LogServiceDbImpl logServiceDb, int count, int page) {
        this.entries = logServiceDb.findByPage(new PageRequest(page, count, Sort.Direction.DESC, "createdAt"));
        this.entry_count = entries.getTotalElements();
    }

    public LogPages() {

    }

    public long getEntry_count() {
        return entry_count;
    }

    public Page<Log> getEntries() {
        return entries;
    }

    public void setEntries(Page<Log> entries) {
        this.entries = entries;
    }

    public void setEntry_count(long entry_count) {
        this.entry_count = entry_count;
    }
}
