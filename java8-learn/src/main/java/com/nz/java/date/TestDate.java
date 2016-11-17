package com.nz.java.date;

import java.time.Clock;
import java.time.DayOfWeek;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.Locale;

/**
 * API under the package java.time
 */
public class TestDate {

    public static void main(String[] args) {

        // clock
        // provides access to the current date and time
        // can be used instead of System.currentTimeMillis()
        Clock clock = Clock.systemDefaultZone();
        long millis = clock.millis();

        Instant instant = clock.instant();
        // legacy java.util.Date
        Date legacyDate = Date.from(instant);

        // Timezones
        System.out.println(ZoneId.getAvailableZoneIds()); // get all ids

        ZoneId zone1 = ZoneId.of("Europe/Berlin");
        ZoneId zone2 = ZoneId.of("Brazil/East");
        System.out.println(zone1.getRules());  // ZoneRules[currentStandardOffset=+01:00]
        System.out.println(zone2.getRules());   // ZoneRules[currentStandardOffset=-03:00]

        // localTime
        // time without a timezone
        LocalTime now1 = LocalTime.now(zone1);
        LocalTime now2 = LocalTime.now(zone2);

        System.out.println(now1.isBefore(now2));   // false

        long hoursBetween = ChronoUnit.HOURS.between(now1, now2);
        long minutesBetween = ChronoUnit.MINUTES.between(now2, now1);

        System.out.println(hoursBetween);  // -1
        System.out.println(minutesBetween);  // 179

        // parsing time strings
        LocalTime late = LocalTime.of(23, 59, 59);
        System.out.println(late);  // 23:59:59

        DateTimeFormatter germanFormatter = DateTimeFormatter
                .ofLocalizedTime(FormatStyle.SHORT)
                .withLocale(Locale.GERMAN);

        LocalTime leetTime = LocalTime.parse("23:37", germanFormatter);
        System.out.println(leetTime); // 23:37

        // localDate
        // represent a distinct date; immutable
        LocalDate today = LocalDate.now();
        LocalDate tomorrow = today.plus(1, ChronoUnit.DAYS);
        LocalDate yesterday = tomorrow.minusDays(2);
        System.out.println(yesterday); // 2016-11-16

        LocalDate independenceDay = LocalDate.of(2014, Month.JULY, 4);
        DayOfWeek dayOfWeek = independenceDay.getDayOfWeek();
        System.out.println(dayOfWeek); // Friday

        // parsing localDate from strings
        DateTimeFormatter germanFormatter1 = DateTimeFormatter
                .ofLocalizedDate(FormatStyle.MEDIUM)
                .withLocale(Locale.GERMAN);

        LocalDate xmas = LocalDate.parse("24.12.2014", germanFormatter1);
        System.out.println(xmas);  // 2014-12-24

        // localDate Time
        // immutable
        // retrieving certain fields from a date-time
        LocalDateTime sylvester = LocalDateTime.of(2014, Month.DECEMBER, 31, 23, 59, 59);

        DayOfWeek dayOfWeek1 = sylvester.getDayOfWeek();
        System.out.println(dayOfWeek1);  // WEDNESDAY

        Month month = sylvester.getMonth();
        System.out.println(month);  // DECEMBER

        long minuteOfDay = sylvester.getLong(ChronoField.MINUTE_OF_DAY);
        System.out.println(minuteOfDay);  // 1439

        // with timezone, it can be converted to an instant
        Instant instant1 = sylvester.atZone(ZoneId.systemDefault()).toInstant();
        Date legacyDate1 = Date.from(instant1);
        System.out.println(legacyDate1);  // Wed Dec 31 23:59:59 EST 2014

        // formatting date-times
        // we can create formatters from custom patterns
        DateTimeFormatter formatter = DateTimeFormatter
                .ofPattern("MMM dd, yyyy - HH:mm");

        LocalDateTime parsed = LocalDateTime.parse("Nov 03, 2014 - 07:13", formatter);
        String s = formatter.format(parsed); // Nov 03, 2014 - 07:13
        System.out.println(s);

        // DateTimeFormatter is immutable and thread-safe

    }
}
