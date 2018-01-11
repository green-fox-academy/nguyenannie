package com.greenfox.programmerfoxclub.Service;

import com.greenfox.programmerfoxclub.Model.Fox;
import com.greenfox.programmerfoxclub.Repository.FoxRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FoxService {

    @Autowired
    private FoxRepository foxRepository;

    public FoxService() {
        super();
    }

    public List<Fox> findAll() {
        return this.foxRepository.findAll();
    }

    public void add(final Fox fox) {
        this.foxRepository.add(fox);
    }
}
