package com.greenfoxacademy.annie.lagopusspringexam.models.DTOs;

public class ResponseDto {

    private String status;

    public ResponseDto() {

    }

    public ResponseDto(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}
