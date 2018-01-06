package com.greenfox.nguyenannie.controllers;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.concurrent.atomic.AtomicLong;

public class Greeting {
    private long id;
    private String content;
    private String foobar;

    public Greeting() {
    }

    public Greeting(long id, String content) {
        this.id = id;
        this.content = content;
        this.foobar = "ANNIE";
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

    public String getFoobar() {
        return foobar;
    }

    //play with how reflection works in java and how springboot reads getter from a class
    public  String getfizzbuzz() {
        String s = "";
        for(Method m : this.getClass().getDeclaredMethods()) {
            if(m.getName().startsWith("get") && !m.getName().equals("getfizzbuzz")) {
                try {
                    s = s + m.getReturnType().getName() + " " + m.getName() + "() { return " + m.invoke(this).toString() + " } ";
                } catch(Exception e){
                    s += e.toString() + " ";
                }
            }
        }
        return s;
    }
}
