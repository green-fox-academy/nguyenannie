package com.greenfox.tamagochi.Service;

import com.greenfox.tamagochi.Model.Trick;
import com.greenfox.tamagochi.Repository.TrickRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
