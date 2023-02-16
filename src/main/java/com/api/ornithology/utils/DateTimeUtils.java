package com.api.ornithology.Utils;

import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class DateTimeUtils {
    public static Date now() { return Calendar.getInstance(timezone()).getTime();}

    public static TimeZone timezone() { return TimeZone.getTimeZone("America/Sao_Paulo");}
}
