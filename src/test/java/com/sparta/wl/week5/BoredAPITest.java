package com.sparta.wl.week5;

import org.junit.jupiter.api.*;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.LocalDate;

public class BoredAPITest {
    HttpClient client;
    HttpRequest request;
    HttpResponse<String> response;

    @BeforeAll
    static void setUpAll(TestInfo testInfo) {
        System.out.println(testInfo.getDisplayName() + " has started");
        System.out.println(testInfo.getClass());
    }

    @BeforeEach
    void setUp(TestInfo testInfo) {
        client = HttpClient.newHttpClient();
        request = HttpRequest.newBuilder().uri(URI.create("https://api.chucknorris.io/jokes/random")).build();
        try {
            response = client.send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    @DisplayName("Test Header")
    void testHeader() {
        Assertions.assertTrue(response.headers() != null);
    }

    @Test
    @DisplayName("Test Status Code must return 200")
    void testStatusCode200() {
        Assertions.assertEquals(200, response.statusCode());
    }

    @Test
    @DisplayName("Test Body")
    void testBody() {
        Assertions.assertTrue(response.body() != null);
    }

    @AfterAll
    static void teamDownAll(TestInfo testInfo) {
        System.out.println(testInfo.getDisplayName() + " has finished");
    }
}
