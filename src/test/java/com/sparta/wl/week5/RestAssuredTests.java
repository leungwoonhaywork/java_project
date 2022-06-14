package com.sparta.wl.week5;

import io.restassured.response.Response;
import net.bytebuddy.agent.VirtualMachine;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;

public class RestAssuredTests {
    private Response response;

    @BeforeEach
    void setup() {
        response = get("");
    }


    @Test
    @DisplayName("Check that url return 200")
    void checkThatUrlReturn200() {
        //Fluent API
        String serverHeader = when().get("https://www.google.co.uk").getHeader("Server");
        System.out.println(serverHeader);
    }

    @Test
    @DisplayName("What does a Response carry?")
    void whatDoesAResponseCarry() {
        System.out.println(response.statusCode());
    }

    @Test
    @DisplayName("Using JacksonTree")
    void usingJacksonTree() {

    }
}
