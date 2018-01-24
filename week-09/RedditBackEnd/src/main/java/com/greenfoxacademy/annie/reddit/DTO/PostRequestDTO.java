package com.greenfoxacademy.annie.reddit.DTO;

import org.springframework.stereotype.Component;

@Component
public class PostRequestDTO {
    private String title;
    private String url;

    public PostRequestDTO() {

    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
