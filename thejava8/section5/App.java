package thejava8.section5;

import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Date;

public class App {
    public static void main(String[] args) throws InterruptedException{
//        Instant instant = Instant.now();
//        System.out.println(instant);
//        System.out.println(instant.atZone(ZoneId.of("UTC")));
//
//        ZoneId zone = ZoneId.systemDefault();
//        System.out.println(zone);
//        ZonedDateTime zonedDateTime = instant.atZone(ZoneId.systemDefault());
//        System.out.println(zonedDateTime);
//        LocalDateTime now = LocalDateTime.now();
//        System.out.println(now);
//        LocalDateTime birthDay = LocalDateTime.of(1995, Month.JANUARY, 17, 0 ,0 ,0);
//        System.out.println(birthDay);
//
//        ZonedDateTime nowInKorea = ZonedDateTime.now(ZoneId.of("Asia/Seoul"));
//        System.out.println(nowInKorea);

//        LocalDate today = LocalDate.now();
//        LocalDate thisYearBirthday = LocalDate.of(2023, Month.DECEMBER, 25);
//
//        Period period = Period.between(today, thisYearBirthday);
//        System.out.println(period.getDays());
//
//        Period until = today.until(thisYearBirthday);
//        System.out.println(until.get(ChronoUnit.DAYS));

//        Instant now = Instant.now();
//        Instant plus = now.plus(10, ChronoUnit.SECONDS);
//        Duration between = Duration.between(now, plus);
//        System.out.println(between.getSeconds());


        Date date = new Date();
        Instant instant = date.toInstant();
        Date newDate = Date.from(instant);

        GregorianCalendar gregorianCalendar = new GregorianCalendar();
//        LocalDateTime dateTime = gregorianCalendar.toZonedDateTime();
        LocalDateTime dateTime = gregorianCalendar.toInstant().atZone();

        LocalDateTime now = LocalDateTime.now();
        System.out.println(DateTimeFormatter.ISO_LOCAL_DATE_TIME);
        DateTimeFormatter MMddyyyy = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        System.out.println(now.format(MMddyyyy));

        LocalDate parse = LocalDate.parse("07/15/1982", MMddyyyy);
        System.out.println(parse);


    }
}
