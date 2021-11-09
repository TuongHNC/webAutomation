package helpers;

import java.text.DateFormatSymbols;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class DateTimeHelper {

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
