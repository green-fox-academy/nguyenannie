package com.greenfox.nguyenannie.birthdaycalculator;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class BirthdayWithLocalDate implements BirthdayCalculator<LocalDate> {

    @Override
    public LocalDate parseDate(String str) {
        return LocalDate.parse(str, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
    }

    @Override
    public String printMonthAndDay(LocalDate date) {
        return date.format(DateTimeFormatter.ofPattern("MM. dd."));
    }

    @Override
    public boolean isAnniversaryToday(LocalDate date) {
        LocalDate today = LocalDate.now();
        return (today.getMonthValue() == date.getMonthValue() && today.getDayOfMonth() == date.getDayOfMonth());
    }

    @Override
    public int calculateAgeInYears(LocalDate birthday) {
        LocalDate today = LocalDate.now();
        Period period = birthday.until(today);
        return period.getYears();
    }

    @Override
    public int calculateDaysToNextAnniversary(LocalDate date) {
        LocalDate today = LocalDate.now();
        int tilTheEndOfThisYear = LocalDate.of(today.getYear(), 12, 31).getDayOfYear() - today.getDayOfYear();

        if(today.getYear() == date.getYear()) {
            return date.getDayOfYear() - today.getDayOfYear();
        } else {
            return tilTheEndOfThisYear + date.getDayOfYear();
        }
    }
}
