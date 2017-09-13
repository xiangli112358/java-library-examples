package me.dev1001.examples.jodatime;


import org.joda.time.DateTime;

import java.time.ZoneId;

/**
 * @author hongzong.li
 */
public class LocalDateTimeExample {
    public static void main(String[] args) {
        DateTime dateTime = new DateTime();
        System.out.println(dateTime);

        System.out.println(ZoneId.systemDefault());
    }
}
