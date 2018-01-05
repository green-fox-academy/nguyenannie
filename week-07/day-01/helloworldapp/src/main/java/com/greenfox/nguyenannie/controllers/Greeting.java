package com.greenfox.nguyenannie.controllers;

import java.util.concurrent.atomic.AtomicLong;

public class Greeting {
    private long id;
    private String content;

    AtomicLong atomicLong;

    public Greeting() {
    }

    public Greeting(long id, String content) {
        this.id = id;
        this.content = content;
        atomicLong= new AtomicLong(id);
    }

    public long next() {
        return atomicLong.getAndIncrement();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
