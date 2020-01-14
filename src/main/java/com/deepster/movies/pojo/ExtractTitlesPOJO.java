package com.deepster.movies.pojo;

import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class ExtractTitlesPOJO {

    private String urlFormat ;

    private final OkHttpClient client = new OkHttpClient();
    private final ObjectMapper mapper = new ObjectMapper();

    public ExtractTitlesPOJO(String urlFormat) {
        this.urlFormat = urlFormat;
    }

    public long getMovieTitles(String subStr) {

        MoviesResponse res = processPage(subStr, 1);
        int totalPages = res.getTotalPages();

        return Stream.concat(res.getData().stream(),
                IntStream.rangeClosed(2, totalPages)
                        .parallel()
                        .mapToObj(i -> processPage(subStr, i).getData())
                        .peek(movies -> System.out.println("com.deepster.movies = " + movies))
                        .flatMap(movieList -> movieList.stream()))
                .map(movie -> movie.getTitle())
                .count();
//                .collect(Collectors.toList());
    }

    private MoviesResponse processPage(String subStr, int page)  {

        final String requestUrl = String.format(urlFormat, subStr, page);
        Request request = new Request.Builder().url(requestUrl).build();
        System.out.println("requestUrl = " + requestUrl);

        MoviesResponse moviesResponse = null;
        try (Response response = client.newCall(request).execute()){
            byte[] jsonBytes = response.body().bytes();

            moviesResponse = mapper.readValue(jsonBytes, MoviesResponse.class);

        } catch (IOException e) {
            System.err.println("Exception " + e.getMessage());
            e.printStackTrace();
        }
        return moviesResponse;
    }

}
