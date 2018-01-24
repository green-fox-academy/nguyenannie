package com.greenfoxacademy.restexercise.Model;

import com.greenfoxacademy.restexercise.Model.RestResponse;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.time.LocalDateTime;

@Component
@Entity
public class Log extends RestResponse{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String createdAt;
    private String endPoint;
    private String data;

    public Log() {
        this.createdAt = String.valueOf(LocalDateTime.now());
    }

    public Log(String endpoint, String data) {
        this.endPoint = endpoint;
        this.data = data;
        this.createdAt = String.valueOf(LocalDateTime.now());
    }

    public String getEndPoint() {
        return endPoint;
    }

    public void setEndPoint(String endPoint) {
        this.endPoint = endPoint;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }
}
