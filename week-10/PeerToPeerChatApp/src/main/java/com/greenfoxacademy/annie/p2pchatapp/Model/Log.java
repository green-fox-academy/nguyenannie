package com.greenfoxacademy.annie.p2pchatapp.Model;

import java.time.LocalDateTime;
import java.util.Objects;

public class Log {
    private String path;
    private String method;
    private LocalDateTime timestamp;
    private String loglevel;
    private String requestdata;

    public Log() {
        this.timestamp = LocalDateTime.now();
    }

    public Log(String path, String method, String loglevel, String requestdata) {
        this.path = path;
        this.method = method;
        this.timestamp = LocalDateTime.now();
        this.loglevel = loglevel;
        this.requestdata = requestdata;
    }

    public static void log(String path, String method, String loglevel, String requestdata) {
        if(!Objects.equals(System.getenv("CHAT_APP_LOGLEVEL"), "ERROR") || Objects.equals(loglevel, "ERROR")) {
            System.out.println( LocalDateTime.now() + " " + loglevel + " Request " + path
                    + " " + method + " " + requestdata);
        }
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public String getLoglevel() {
        return loglevel;
    }

    public void setLoglevel(String loglevel) {
        this.loglevel = loglevel;
    }

    public String getRequestdata() {
        return requestdata;
    }

    public void setRequestdata(String requestdata) {
        this.requestdata = requestdata;
    }

    @Override
    public String toString() {
        return this.timestamp + " " + this.loglevel + " Request " + this.path
                + " " + this.method + " " + this.requestdata;
    }
}
