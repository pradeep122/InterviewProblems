package com.deepster.movies;

import com.deepster.movies.pojo.ExtractTitlesPOJO;

public class Main {
    private static final String urlFormat = "https://jsonmock.hackerrank.com/api/movies/search/?Title=%s&page=%s";

    public static void main(String[] args) {


        // Extracting data in parallel from Java POJOs
        final ExtractTitlesPOJO extractTitlesPOJO = new ExtractTitlesPOJO(urlFormat);
        final long count = extractTitlesPOJO.getMovieTitles("nightout");
        System.out.println("count = " + count);

        // Extracting data on the fly
//        ExtactTitlesOnTheFly movieTitles = new ExtactTitlesOnTheFly(urlFormat);
//        List<String> titles = new ArrayList<>();
//        titles = movieTitles.getMovieTitles("List");
//        titles.stream().forEach(System.out::println);

    }
}
