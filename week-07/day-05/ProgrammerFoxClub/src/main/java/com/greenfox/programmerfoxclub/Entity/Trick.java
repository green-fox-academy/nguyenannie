package com.greenfox.programmerfoxclub.Entity;

public enum Trick {
    html("Write HTML"),
    Java("code in Java"),
    Haskell("code in Haskell"),
    cplus("code in C++"),
    csharp("code in C#"),
    css("design with css"),
    js("code in JavaScript");

    String value;

    Trick(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}
