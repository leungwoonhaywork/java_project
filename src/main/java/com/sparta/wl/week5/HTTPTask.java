package com.sparta.wl.week5;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.FileReader;
import java.io.IOException;
import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class HTTPTask {
    public static void main(String[] args) {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create("https://api.chuckasdfanorris.io/jokes/random")).build();
        //HttpRequest request = HttpRequest.newBuilder().uri(URI.create("https://api.chucknorris.io/jokes/random")).build();

        //try {
        //    HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        //} catch (IOException e) {
        //    e.printStackTrace();
        //} catch (InterruptedException e) {
        //    e.printStackTrace();
        //}

        ObjectMapper mapper = new ObjectMapper();
        //try {
        //    //BoredResponse response = mapper.readValue(new URL("https://www.boredapi.com/api/activity/"), BoredResponse.class);
        //    //System.out.println(response.getActivity());
        //    BoredResponse response = mapper.readValue(new FileReader("src/main/resources/week5/rates.json"), BoredResponse.class);
//
        //} catch (IOException e) {
        //    e.printStackTrace();
        //}

    }
}
