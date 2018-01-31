package com.greenfoxacademy.annie.p2pchatapp.Controller;

import com.greenfoxacademy.annie.p2pchatapp.DTO.Error;
import com.greenfoxacademy.annie.p2pchatapp.Model.Appmessage;
import com.greenfoxacademy.annie.p2pchatapp.Model.Appuser;
import com.greenfoxacademy.annie.p2pchatapp.Service.AppuserService;
import com.greenfoxacademy.annie.p2pchatapp.Service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.greenfoxacademy.annie.p2pchatapp.DTO.*;

import java.time.Instant;

@RestController
public class restController {
    private final MessageService messageService;
    private final AppuserService appuserService;

    @Autowired
    public restController(MessageService messageService, AppuserService appuserService) {
        this.messageService = messageService;
        this.appuserService = appuserService;
    }

    @PostMapping("/api/message/receive")
    public ResponseEntity<?> receive(@RequestBody MessageRequestBodyDTO bodyDTO) {
        if(bodyDTO.isNotValid()) {
            Error error = new Error();
            error.setStatus("error");
            error.setMessage("Missing field(s): " + bodyDTO.listOfMissingFields());
            return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
        } else {
            ResponseDTO responseDTO = new ResponseDTO();
            responseDTO.setStatus("ok");
            Appuser appuser = appuserService.findByName(bodyDTO.getClient().getId());
            if(appuser == null) {
                appuser = new Appuser(bodyDTO.getClient().getId());
            }
            Appmessage appmessage = new Appmessage(appuser, bodyDTO.getMessage().getText(),
                    bodyDTO.getMessage().getId(), Instant.ofEpochMilli(bodyDTO.getMessage().getTimestamp()));
            messageService.save(appmessage);
            return new ResponseEntity<>(responseDTO, HttpStatus.OK);
        }
    }

}
