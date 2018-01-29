package com.greenfoxacademy.annie.p2pchatapp.Model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class UniqueRandomNumber {
    private static final List<Integer> randIntegers = new Random().ints(1000000, 9999999)
            .distinct().limit(1000).boxed().collect(Collectors.toList());
    private static int count = 0;

    public UniqueRandomNumber() {

    }

    public static int generate() {
        count += 1;
        return randIntegers.get(count);
    }
}
