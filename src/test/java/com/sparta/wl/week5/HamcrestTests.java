package com.sparta.wl.week5;

import org.junit.jupiter.api.*;

import java.time.LocalDate;

public class HamcrestTests {
    private Spartan spartan;

    @BeforeEach
    void setup(TestInfo testInfo) {
        System.out.println(testInfo.getDisplayName() + " is running");
        spartan = new Spartan(1, "Spartan", "Java", LocalDate.of(2022, 4, 4));
    }

    @Test
    @DisplayName("")
    void tes() {
        Assertions.assertEquals(1, 1);
    }
}
