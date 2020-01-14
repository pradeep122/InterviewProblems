package com.deepster.formattor;

import java.util.List;

public class Main {
    public static void main(String[] args) {


        List<Integer> testList = List.of(
                123456789,
                123,
                19,
                21,
                119,
                1234,
                12345,
                Integer.MAX_VALUE,
                1000,
                101,
                100000,
                10000000,
                1000000000,
                1000000001,
                1010101010,
                1400000000,
                2134567089,
                1,
                -1,
                0
        );



        LocaleMap IndianMap = new IndianLocaleMap();
        System.out.println("IndianMap = " + IndianMap.getMap());
        testList.stream()
                .map(integer -> integer + "  --> " + IndianMap.formatNumber(integer))
                .forEach(System.out::println);


        LocaleMap AmericanMap = new AmericanLocaleMap();
        System.out.println("AmericanMap = " + AmericanMap.getMap());
        testList.stream()
                .map(integer -> integer + "  --> " + AmericanMap.formatNumber(integer))
                .forEach(System.out::println);

    }
}
