package nyc.c4q.ac21.calendar;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;

public class DateTools {
    /**
     * Formats a 'Calendar' object as a date.
     * @param cal
     *   The object to format.
     * @return
     *   The date in "YYYY-MM-DD" format.
     */
    public static String formatDate(Calendar cal) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        return format.format(cal.getTime());
    }

    /**
     * Parses a date in "YYYY-MM-DD" format.
     * @param date
     *   The date in "YYYY-MM-DD" format.
     * @return
     *   The date it represents, or null if the date is incorrectly formatted.
     */
    public static Calendar parseDate(String date) {
        if (date.length() == 10 && date.charAt(4) == '-' && date.charAt(7) == '-') {
            try {
                int year = Integer.valueOf(date.substring(0, 4));
                int month = Integer.valueOf(date.substring(5, 7));
                int dayOfMonth = Integer.valueOf(date.substring(8, 10));
                if (year > 0 && year <= 9999
                        && month >= 1 && month <= 12
                        && dayOfMonth >= 1 && dayOfMonth <= 31) {
                    // Allocate directly instead of using Calendar.getInstance() so that we don't
                    // set the time fields and leave them initialized to zero.
                    return new GregorianCalendar(year, month - 1, dayOfMonth);
                }
            } catch (NumberFormatException exception) {
                // Fall through.
            }
        }
        // Didn't work.
        return null;
    }

    /**
     * Returns the following day.
     */
    public static Calendar getNextDay(Calendar cal) {
        // 'Calendar' is mutable, but we don't want to change it.  Instead, create a copy and change that.
        cal = (Calendar) cal.clone();
        cal.add(Calendar.DAY_OF_MONTH, 1);
        return cal;
    }

    /**
     * Builds and returns a map from integers representing days of the week to the names of the days of the week.
     * @return
     *   A map with keys 'Calendar.MONDAY' through 'Calendar.SUNDAY' with corresponding day names as values.
     */
    public static HashMap<Integer, String> getDayOfWeekNames() {
        HashMap<Integer, String> names = new HashMap<Integer, String>();

        names.put(1, "Sunday");
        names.put(2, "Monday");
        names.put(3, "Tuesday");
        names.put(4, "Wednesday");
        names.put(5, "Thursday");
        names.put(6, "Friday");
        names.put(7, "Saturday");

        return names;
    }

    public static HashMap<Integer, String> getMonthNames() { // used to print calendar printer
        HashMap<Integer, String> month = new HashMap<Integer, String>();

        month.put(0, "January");
        month.put(1, "February");
        month.put(2, "March");
        month.put(3, "April");
        month.put(4, "May");
        month.put(5, "June");
        month.put(6, "July");
        month.put(7, "August");
        month.put(8, "September");
        month.put(9, "October");
        month.put(10, "November");
        month.put(11, "December");

        return month;
    }

}
