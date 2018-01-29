package com.greenfoxacademy.annie.p2pchatapp.Service;

import com.greenfoxacademy.annie.p2pchatapp.Model.Appmessage;
import com.greenfoxacademy.annie.p2pchatapp.Repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MessageServiceDbImpl implements MessageService {

    private final MessageRepository messageRepository;

    @Autowired
    public MessageServiceDbImpl(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    @Override
    public List<Appmessage> findAll() {
        List<Appmessage> appmessages = new ArrayList<>();
        messageRepository.findAll().forEach(appmessages::add);
        return appmessages;
    }

    @Override
    public Appmessage findOne(long id) {
        return messageRepository.findOne(id);
    }

    @Override
    public void save(Appmessage appmessage) {
        messageRepository.save(appmessage);
    }
}
