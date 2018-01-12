package com.greenfox.programmerfoxclub.Entity;

public enum Trick {
    html("Write HTML"), Java("code in Java"), Haskell("code in Haskell"), cplus("code in C++");

    String value;

    Trick(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}
