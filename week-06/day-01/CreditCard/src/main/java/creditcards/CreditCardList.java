package main.java.creditcards;

import java.util.ArrayList;
import java.util.List;

public class CreditCardList {
    List<CreditCard> list;

    CreditCardList(int numberOfCards) {
        list = new ArrayList<>();
        for(int i = 0; i < numberOfCards; i++) {
            list.add(new CreditCard("ABC" + i));
        }

    }
}
