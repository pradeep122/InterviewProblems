package com.deepster.formattor;

import javafx.util.Pair;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


public abstract class LocaleMap {
    public static final String separator = " ";
    public static final String and = "and ";
    public static final String zero = "Zero";

    // Order has to be maintained from biggest to smallest denominations
    public abstract List<Pair<Integer, String>> getMap();

    private static final Map<Integer, String> tensMap = Map.of(
            9, "ninety",
            8, "eighty",
            7, "seventy",
            6, "sixty",
            5, "fifty",
            4, "forty",
            3, "thirty",
            2, "twenty"
    );

    private static Map<Integer, String> digitsMap;


    private static final Map<Integer, String> digitsMap() {

        if(digitsMap != null){
            return digitsMap;
        }
        digitsMap = new HashMap<>();

        digitsMap.putAll(Map.of(
                19, "nineteen",
                18, "eighteen",
                17, "seventeen",
                16, "sixteen",
                15, "fifteen",
                14, "fourteen",
                13, "thirteen",
                12, "twelve",
                11, "eleven",
                10, "ten"
        ));
        digitsMap.putAll(Map.of(
                9, "nine",
                8, "eight",
                7, "seven",
                6, "six",
                5, "five",
                4, "four",
                3, "three",
                2, "two",
                1, "one"
        ));
        return digitsMap;
    }

    private StringBuilder format(int number){

        StringBuilder builder = new StringBuilder();

        if(number == 0){
            return builder.append("");
        }

        if(number < 100 && number > 19) {
            return builder.append(tensMap.get(number/10))
                    .append(separator)
                    .append(format(number % 10));
        }

        if (number < 20){
            return builder.append(digitsMap().get(number));
        }

        int quotient = 0;
        int remainder = number;

        for(Pair<Integer, String> pair : this.getMap()){

            int oldRemainder = remainder;
            quotient = remainder / pair.getKey();
            remainder = oldRemainder % pair.getKey();
            if(quotient > 0) {
                builder.append(format(quotient));
                builder.append(separator);
                builder.append(pair.getValue());
                builder.append(separator);
            }

        }
        if( remainder < 100 && remainder > 0){
            builder.append(and);
        }

        builder.append(format(remainder));

        return builder;

    }

    public String formatNumber(int number){
        if (number == 0) return zero;
        String result = format(number).toString();
        return result.substring(0, 1).toUpperCase() + result.substring(1);
    }

}
