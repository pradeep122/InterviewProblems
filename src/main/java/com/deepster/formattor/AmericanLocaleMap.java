package com.deepster.formattor;

import java.util.List;
import javafx.util.Pair;


public class AmericanLocaleMap extends LocaleMap {

    // Order has to be maintained from biggest to smallest denominations
    private static final List<Pair<Integer, String>> map = List.of(
            new Pair<>(1000000000, "billion"),
            new Pair<>(1000000, "million"),
            new Pair<>(1000, "thousand"),
            new Pair<>(100,"hundred")
    );

    @Override
    public List<Pair<Integer, String>> getMap() {
        return map;
    }
}
