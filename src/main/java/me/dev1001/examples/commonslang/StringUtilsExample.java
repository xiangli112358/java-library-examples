package me.dev1001.examples.commonslang;

import org.apache.commons.lang3.StringEscapeUtils;

/**
 * @author hongzong.li
 */
public class StringUtilsExample {
    public static void main(String[] args) {
        System.out.println(StringEscapeUtils.escapeJava("\t\"a\""));
    }
}
