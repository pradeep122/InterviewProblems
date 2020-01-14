package com.deepster.movies.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Movie {

    @JsonProperty("Title")
    private String title;
    @JsonProperty("Year")
    private int year;
    private String imdbID;

    public Movie() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImdbID() {
        return imdbID;
    }

    public void setImdbID(String imdbID) {
        this.imdbID = imdbID;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
}
