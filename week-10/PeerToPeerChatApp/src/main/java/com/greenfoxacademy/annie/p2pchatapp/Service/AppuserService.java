package com.greenfoxacademy.annie.p2pchatapp.Service;

import com.greenfoxacademy.annie.p2pchatapp.Model.Appuser;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AppuserService {
    Appuser findOne(int id);
    List<Appuser> findAll();
    void save(Appuser appuser);
    Appuser findByName(String name);
    boolean exist(String name);
}
