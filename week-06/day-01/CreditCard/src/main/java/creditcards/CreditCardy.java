package main.java.creditcards;

public interface CreditCardy {
    int getSumCVV();

    String getNameCardholder();

    String getCodeAccount();

    int computeSumCVV(String codeAccount);

    String toString ();
}
