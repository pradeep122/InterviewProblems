package com.deepster.formattor;

import javafx.util.Pair;

import java.util.List;

public class IndianLocaleMap extends LocaleMap {

    private final List<Pair<Integer, String>> map = List.of(
            new Pair<>(10000000, "crore"),
            new Pair<>(100000, "lakh"),
            new Pair<>(1000, "thousand"),
            new Pair<>(100,"hundred")
    );
    @Override
    public List<Pair<Integer, String>> getMap() {
       return map;
    }
}
