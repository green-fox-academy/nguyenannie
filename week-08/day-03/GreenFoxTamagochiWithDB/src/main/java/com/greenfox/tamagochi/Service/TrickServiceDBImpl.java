package com.greenfox.tamagochi.Service;

import com.greenfox.tamagochi.Model.Tamagochier;
import com.greenfox.tamagochi.Model.Trick;
import com.greenfox.tamagochi.Repository.TrickRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TrickServiceDBImpl implements TrickService {
    private final
    TrickRepository trickRepository;

    @Autowired
    public TrickServiceDBImpl(TrickRepository trickRepository) {
        this.trickRepository = trickRepository;
    }

    @Override
    public void addNewTrick(Trick newTrick) {
        trickRepository.save(newTrick);
    }

    @Override
    public Trick searchOneByName(String name) {
        return trickRepository.findByName(name);
    }

    @Override
    public List<Trick> getAllTricks() {
        List<Trick> tricks = new ArrayList<>();
        trickRepository.findAll().forEach(tricks::add);
        return tricks;
    }
}
