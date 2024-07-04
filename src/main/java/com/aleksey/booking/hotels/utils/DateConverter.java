package com.aleksey.booking.hotels.utils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateConverter {

    public static LocalDate fromStringDateToLocalDate(String date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return LocalDate.parse(date, formatter);
    }
}