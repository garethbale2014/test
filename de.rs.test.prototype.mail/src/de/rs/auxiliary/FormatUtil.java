package de.rs.auxiliary;

import java.sql.Timestamp;

import java.text.DateFormat;

import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;



/**
 * The class supports some format methods.
 * 
 * @since 1.0
 * @author RSahili
 */
public class FormatUtil {

    /**
     * Standard format for time stamp. <br>
     */
    private static final Format formatDefault = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");

    /**
     * Returns the given time stamp (in milliseconds) as string formatted by the formatter: {@link FormatUtil#format};
     * 
     * @return time
     */
    public static String toTimeString(Timestamp timeStamp) {
        return toLongStringTime(timeStamp);
    }

    private static String toLongStringTime(Timestamp timeStamp) {
        int nanos = timeStamp.getNanos();
        String strTimeStamp = formatDefault.format(timeStamp.getTime());
        StringBuilder timeStr = new StringBuilder(strTimeStamp);
        String nanoStr = new Integer(nanos).toString();
        String microStr = "";
        String Hundert_thMicroPart = strTimeStamp.substring(20, 21);
        boolean isZero = Hundert_thMicroPart.equals("0") ? true : false;
        if (nanoStr.length() == 5)
            microStr = "0" + nanoStr.substring(3, 5);
        else if (nanoStr.length() == 4)
            microStr = "00" + nanoStr.substring(3, 4);
        else if (nanoStr.length() <= 3)
            microStr = "000";
        else if (isZero)
            microStr = nanoStr.substring(2, 5);
        else
            microStr = nanoStr.substring(3, 6);
        // System.out.println("FormatUtil : "+strTimeStamp);
        return timeStr.append(microStr).toString();
    }

    /**
     * 
     * @param time
     * @return
     */
    public static Long toTimeLong(String time) {
        DateFormat formatter;
        Date date;
        formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSSSSS");
        try {
            date = (Date) formatter.parse(time);
            return date.getTime();
        } catch (ParseException e) {

        }
        return null;
    }

    public static Timestamp toStringTimestamp(String strTimestamp) {
       if(StringUtils.isNullOrEmpty(strTimestamp))
           throw new IllegalArgumentException(strTimestamp);
        String strMain = strTimestamp.substring(0, strTimestamp.length());
        Timestamp timestamp = Timestamp.valueOf(strMain);
        // String micro = strTimestamp.substring(strTimestamp.length() - 3, strTimestamp.length());
        // timestamp.setNanos(timestamp.getNanos() + new Integer(micro) * 1000);
        return timestamp;
    }

    public static String dbToTimeString(String strTimestamp) {
        // System.out.println("FormatUtil timestamp : "+strTimestamp);
        try {
            // if(strTimestamp != null){
            // String strMain = strTimestamp.substring(0, strTimestamp.length());
            // Timestamp timestamp = Timestamp.valueOf(strMain);
            // return toTimeString(timestamp);
            // }

            if (strTimestamp.length() < 26)
                System.out.println(strTimestamp);
            if (strTimestamp != null) {
                String strMain = strTimestamp.substring(0, strTimestamp.length());
                Timestamp timestamp = Timestamp.valueOf(strMain);
                String micro = "";
                if (strTimestamp.length() == 26)
                    micro = strTimestamp.substring(strTimestamp.length() - 3, strTimestamp.length());
                else if (strTimestamp.length() == 25)
                    micro = strTimestamp.substring(strTimestamp.length() - 2, strTimestamp.length());
                else if (strTimestamp.length() == 24)
                    micro = strTimestamp.substring(strTimestamp.length() - 1, strTimestamp.length());

                if (micro.length() == 2)
                    micro += "0";
                else if (micro.length() == 1)
                    micro += "00";
                else if (micro.length() == 0)
                    micro += "000";
                //timestamp.setNanos(timestamp.getNanos() + new Integer(micro) * 1000);
                return toTimeString(timestamp);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 
     * @param value
     * @param format
     * @return
     */
    public static String toDateString(Object value, Format format) {
        if (format == null)
            format = formatDefault;
        if (value == null || value.equals("")) {
            return null;
        }
        if (value instanceof Date) {
            return format.format(value);
        } else if (value instanceof Calendar) {
            format.format(((Calendar) value).getTime());
        } else if (value instanceof Timestamp) {
            format.format(((Timestamp) value).getTime());
        }
        throw new IllegalArgumentException("Invalid value type.");
    }
}
