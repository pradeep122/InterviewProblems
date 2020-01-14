package com.deepster.movies.dynamic;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ExtactTitlesOnTheFly {

    private String urlFormat ;

    private final OkHttpClient client = new OkHttpClient();
    private final ObjectMapper mapper = new ObjectMapper();

    public ExtactTitlesOnTheFly(String urlFormat) {
        this.urlFormat = urlFormat;
    }

    public List<String> getMovieTitles(String subStr) {

        final MovieTitleResponse res = processPage(subStr, 1);
        List<String> titles = res.titles;
        if (res.totalPages > 1){
            for (int i = 2; i <= res.totalPages; i++) {
                titles.addAll(processPage(subStr, i).titles);
            }
        }
        return titles;
    }

    private MovieTitleResponse processPage(String subStr, int page) {

        final String requestUrl = String.format(urlFormat, subStr, page);
        Request request = new Request.Builder().url(requestUrl).build();
        List<String> movieTitles = new ArrayList<>();
        int totalPages = 0;
        System.out.println("requestUrl = " + requestUrl);
        try (Response response = client.newCall(request).execute()){
            byte[] jsonBytes = response.body().bytes();

            final JsonNode root = mapper.readTree(jsonBytes);

            final int total = root.path("total").asInt(0);
            totalPages = root.path("total_pages").asInt(0);
            root.path("data").elements().forEachRemaining(jsonNode -> {
                movieTitles.add(jsonNode.path("Title").asText());
            });

        } catch (IOException e) {
            e.printStackTrace();
        }
        return new MovieTitleResponse(movieTitles, totalPages);
    }

}
