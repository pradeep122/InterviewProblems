package com.deepster.movies.dynamic;

import java.util.List;

public class MovieTitleResponse {
    public List<String> titles;
    public int totalPages;

    public MovieTitleResponse(List<String> titles, int totalPages) {
        this.titles = titles;
        this.totalPages = totalPages;
    }
}
