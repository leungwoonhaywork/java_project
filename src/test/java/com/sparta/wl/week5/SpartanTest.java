package com.sparta.wl.week5;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class SpartanTest {
    private Spartan spartan;
    static List<Spartan> spartans = new ArrayList<>();

    @BeforeAll
    static void setUpAll(TestInfo testInfo) {
        System.out.println(testInfo.getDisplayName() + " has started");
        System.out.println(testInfo.getClass());
    }

    @BeforeEach
    void setUp(TestInfo testInfo) {
        System.out.println(testInfo.getDisplayName() + " is running");
        spartan = new Spartan(1, "Spartan1", "Java", LocalDate.of(2022, 4, 4));
        spartans.add(spartan);
        spartan = new Spartan(2, "Spartan2", "Java", LocalDate.of(2022, 4, 4));
        spartans.add(spartan);
        spartan = new Spartan(3, "Spartan3", "Java", LocalDate.of(2022, 4, 4));
        spartans.add(spartan);
    }

    @ParameterizedTest
    @MethodSource("testListSpartan")
    @DisplayName("Test ID Positive")
     void testIdPositive() {
        Assertions.assertTrue(spartan.getId() > 0);
    }

    @ParameterizedTest
    @MethodSource("testListSpartan")
    @DisplayName("Test Name must not empty")
    void testNameEmpty(Spartan spartan) {
        Assertions.assertTrue(spartan.getName() != null || spartan.getName().replaceAll("\\s+","") != "");
    }

    @ParameterizedTest
    @MethodSource("testListSpartan")
    @DisplayName("Test Name must not include special character")
    void testNameNoSpecialCharacter() {
        Assertions.assertTrue(!Pattern.compile("[^a-z0-9 ]", Pattern.CASE_INSENSITIVE).matcher(spartan.getName()).find());
    }

    @Test
    @DisplayName("Id must not be repeat")
    void testidNoRepeat() {
        boolean isRepeat = false;
        for (int i = 0; i < spartans.size(); i ++) {
            for (int j = i + 1; j < spartans.size(); j ++) {
                if (spartans.get(i).getId() == spartans.get(j).getId()) {
                    isRepeat = true;
                }
            }
        }
        Assertions.assertTrue(!isRepeat);
    }

    @AfterAll
    static void teamDownAll(TestInfo testInfo) {
        System.out.println(testInfo.getDisplayName() + " has finished");
    }

    static List<Spartan> testListSpartan() {
        Spartan spartan;
        List<Spartan> spartans = new ArrayList<>();
        spartan = new Spartan(1, "Spartan1", "Java", LocalDate.of(2022, 4, 4));
        spartans.add(spartan);
        spartan = new Spartan(2, "Spartan2", "Java", LocalDate.of(2022, 4, 4));
        spartans.add(spartan);
        spartan = new Spartan(3, "Spartan3", "Java", LocalDate.of(2022, 4, 4));
        spartans.add(spartan);

        return spartans;
    }

}
