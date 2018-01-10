package com.greenfoxacademy.hellobeanworld.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BlueColor implements MyColor {

    @Autowired
    Printer printer;

    @Override
    public void printColor() {
        printer.log("It is blue color");
    }
}
