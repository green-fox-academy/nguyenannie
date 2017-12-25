package main.java.creditcardreservations;
import creditcards.*;
import reservations.*;

import java.util.Random;

public class CreditCardReservation implements Reservationy, CreditCardy {
    private String code;
    private String dow;
    private String cardHolderName;
    private String codeAccount;
    private static final String ALPHANUMERIC_CHARACTERS = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String[] DOW = {"MON", "TUE", "WED", "THU", "FRI", "SAT", "SUN"};

    CreditCardReservation(String cardHolderName) {
        code = getCodeBooking();
        dow = getDowBooking();
        codeAccount = generateCodeAccount();
        this.cardHolderName = cardHolderName;
    }

    @Override
    public int getSumCVV() {
        return computeSumCVV(codeAccount);
    }

    @Override
    public String getNameCardholder() {
        return cardHolderName;
    }

    private String generateCodeAccount() {
        String CC = "";
        Random r = new Random();
        for(int i = 0; i < 16; i++) {
            int num = r.nextInt(9);
            CC += Integer.toString(num);
        }
        return CC;
    }
    @Override
    public String getCodeAccount() {
        return this.codeAccount;
    }

    @Override
    public int computeSumCVV(String codeAccount) {
        int sum = 0;
        for(int i = 0; i < codeAccount.length(); i++) {
            sum += Character.getNumericValue(codeAccount.charAt(i));
        }
        return sum;
    }

    String getCode() {
        return this.code;
    }

    public String getDow() {
        return dow;
    }

    @Override
    public String getDowBooking() {
        int r = new Random().nextInt(7);
        return DOW[r];
    }

    @Override
    public String getCodeBooking() {
        String result = "";
        for (int i = 0; i < 8; i++) {
            Random r = new Random();
            int offset = r.nextInt(ALPHANUMERIC_CHARACTERS.length());
            result += ALPHANUMERIC_CHARACTERS.substring(offset, offset+1);
        }
        return result;
    }

    @Override
    public String toString() {
        return String.format("Booking# %s for %s paid by Name=%s CC#=%s CVV=%d", getCodeBooking(),
                getDowBooking(), cardHolderName, getCodeAccount(), getSumCVV());
    }
}
