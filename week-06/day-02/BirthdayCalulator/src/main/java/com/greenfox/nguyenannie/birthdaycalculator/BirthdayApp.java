package com.greenfox.nguyenannie.birthdaycalculator;

import java.time.LocalDate;

public class BirthdayApp {
    public static final String MY_BIRTHDAY = "1995-05-27";

    public static void main(String[] args) {
        BirthdayCalculator<LocalDate> birthdayCalculator = new BirthdayWithLocalDate();
        LocalDate myBirthDate = birthdayCalculator.parseDate(MY_BIRTHDAY);

        System.out.println(birthdayCalculator.printMonthAndDay(myBirthDate));
        System.out.println("Is today my birthday? " + birthdayCalculator.isAnniversaryToday(myBirthDate));
        System.out.println("I am " + birthdayCalculator.calculateAgeInYears(myBirthDate) + " year old till this moment.");
        System.out.println("There are still " + birthdayCalculator.calculateDaysToNextAnniversary(myBirthDate) + " days till my next birthday.");
    }
}
