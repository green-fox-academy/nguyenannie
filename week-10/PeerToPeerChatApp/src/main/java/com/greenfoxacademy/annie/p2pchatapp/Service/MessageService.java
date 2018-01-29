package com.greenfoxacademy.annie.p2pchatapp.Service;

import com.greenfoxacademy.annie.p2pchatapp.Model.Appmessage;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface MessageService {
    List<Appmessage> findAll();
    Appmessage findOne(long id);
    void save(Appmessage appmessage);
}
