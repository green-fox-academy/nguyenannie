package com.greenfoxacademy.pallidaretakeexam;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>(Arrays.asList("annie", "annie", "rub", "son", "krisz", "rub"));
        System.out.println(list.stream().distinct().collect(Collectors.toList()));
    }
}
