package edu.wgu.d387_sample_code.translation;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class ConvertTimeZone {

    public static String convertTime() {
        ZonedDateTime time = ZonedDateTime.now();
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm");

        ZonedDateTime eastern = time.withZoneSameInstant(ZoneId.of("America/New_York"));
        ZonedDateTime pacific = time.withZoneSameInstant(ZoneId.of("America/Los_Angeles"));
        ZonedDateTime utc = time.withZoneSameInstant(ZoneId.of("UTC"));

        return eastern.format(timeFormatter) + "ET, " + pacific.format(timeFormatter) + "MT, " + utc.format(timeFormatter) + "UTC";
    }

}
