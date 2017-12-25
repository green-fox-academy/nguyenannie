package main.java.reservations;

import com.sun.org.apache.regexp.internal.RE;

import java.util.Random;

public class Reservations implements Reservationy {
    private static final String ALPHANUMERIC_CHARACTERS = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String[] DOW = {"MON", "TUE", "WED", "THU", "FRI", "SAT", "SUN"};

    private String code;
    private String dow;

    Reservations() {
        code = getCodeBooking();
        dow = getDowBooking();
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

    void formatPrintOut() {
        System.out.println(String.format("Booking# %s for %s", getCodeBooking(), getDowBooking()));
    }
}
