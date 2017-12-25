package main.java.creditcardreservations;

public class CreditCardReservationApp {
    private static final int NUMBER_OF_RESERVATIONS = 10;

    public static void main(String[] args) {
        for(int i = 0; i < NUMBER_OF_RESERVATIONS; i++) {
            CreditCardReservation reserved = new CreditCardReservation("DEF" + i);
            System.out.println(reserved.toString());
        }
    }
}
