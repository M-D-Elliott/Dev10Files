package com.sg.javamilestone3.intmath;

import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Date;

public class Dates {

    public void run() {
        LocalDate ld = LocalDate.now();
        System.out.println(ld);
        ld = LocalDate.parse("2015-01-01");
        System.out.println(ld);
        ld = LocalDate.parse("02/07/2010", DateTimeFormatter.ofPattern("MM/dd/yyyy"));
        System.out.println(ld);
        LocalDate past = ld.minusDays(8);
        System.out.println(past);
        Period diff = ld.until(past);
        System.out.println(diff);

        
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        ld = LocalDate.parse("02/07/2010", formatter);
        String formatted = ld.format(formatter);
        
        System.out.println(formatted);
        //out : 02/07/2010
        
        formatted = ld.format(DateTimeFormatter.ofPattern("MM=dd=yyyy+=+=+="));
        
        System.out.println(formatted);
        // out 02=07=2010+=+=+=
        
        formatted = past.format(
        DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL));
        
        // out Saturday, January 30, 2010
        
        // legacy Date object.
        Date legacyDate = new Date();
        ZonedDateTime zdt = ZonedDateTime.ofInstant(
            legacyDate.toInstant(), ZoneId.systemDefault());
        ld = zdt.toLocalDate();
        System.out.println(ld);
    }

}
