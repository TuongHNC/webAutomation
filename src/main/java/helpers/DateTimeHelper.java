package helpers;

import java.text.DateFormat;
import java.text.DateFormatSymbols;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class DateTimeHelper {

    public static String getCurrentDateTimeByFormat(DateFormat dateFormat) {
        Date date = new Date();
        return dateFormat.format(date);
    }

    public static long getCurrentMilliseconds() {
        return new Date().getTime();
    }

    public static long getTimeBeforeCurrentTime(int minute) {
        return System.currentTimeMillis() - 60*minute*1000;
    }

    public static Date convertStringToDateTime(String dateTime, String dateFormat) throws ParseException {
        return new SimpleDateFormat(dateFormat).parse(dateTime);
    }

    public static String getYesterdayDateString(DateFormat dateFormat) {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE, -1);
        return dateFormat.format(calendar.getTime());
    }

    public static long convertStringDateToMilliseconds(String stringDateTime, DateFormat dateFormat) throws ParseException {
        Date date = dateFormat.parse(stringDateTime);
        return date.getTime();
    }

    /**
     * @return String: Aug 21, 20:20pm
     */
    public static String getcurrentDateTimeSymbol() {
        DateFormatSymbols symbols = new DateFormatSymbols(Locale.getDefault());
        symbols.setAmPmStrings(new String[]{"am", "pm"});

        SimpleDateFormat dateFormat = new SimpleDateFormat("MMM d, hh:mma");
        dateFormat.setDateFormatSymbols(symbols);
        return dateFormat.format(new Date());
    }
}
