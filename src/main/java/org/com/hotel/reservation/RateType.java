package org.com.hotel.reservation;

import org.joda.time.DateTime;
import org.joda.time.DateTimeConstants;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import java.util.List;
import java.util.Locale;

import static com.google.common.collect.Lists.newArrayList;

public enum RateType {
    Weekend,
    Weekday;

    private final List<Integer> daysOfWeek;

    private RateType(Integer... daysOfWeek) {
        this.daysOfWeek = newArrayList(daysOfWeek);
    }

    private static boolean isWeekend(DateTime dateTime) {
        return dateTime.getDayOfWeek() == DateTimeConstants.SATURDAY || dateTime.getDayOfWeek() == DateTimeConstants.SUNDAY;
    }

    public static RateType from(String rawRequest) { // TODO: fix to check all the dates inputted in the request
        String stringDate = rawRequest.split(" ")[1].split("\\(")[0];
        DateTimeFormatter dateTimeFormatter = DateTimeFormat.forPattern("ddMMMyyyy").withLocale(Locale.US);
        DateTime date = DateTime.parse(stringDate, dateTimeFormatter);
        if (isWeekend(date)) {
            return Weekend;
        }
        return Weekday;
    }

/*    public static List<RateType> from(String rawRequest) {
        List<RateType> rateTypes = newArrayList();

        String dates = rawRequest.replaceAll(" *\\(.+?\\)", "").split(":")[1].trim();
        List<String> listDates = Arrays.asList(dates.split("\\s*,\\s*"));

        DateTimeFormatter dateTimeFormatter = DateTimeFormat.forPattern("ddMMMyyyy").withLocale(Locale.US);

        for (String stringDate : listDates) {
            DateTime date = DateTime.parse(stringDate, dateTimeFormatter);
            if (isWeekend(date)) {
                rateTypes.add(Weekend);
            } else {
                rateTypes.add(Weekday);
            }
        }
        return rateTypes;
    }*/

}
