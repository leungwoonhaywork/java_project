package com.sparta.wl.week5;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import java.time.LocalDate;
import java.util.stream.Stream;

public class ParameterizedTests {

    @ParameterizedTest(name = "[{index} Testing for value = {arguments}")
    @ValueSource(ints = {2, 0, 1, 2, 12, 6, 7})
    void checkIfLessThanTen(int number) {
        Assertions.assertTrue(number < 10);
    }
    @ParameterizedTest
    @NullAndEmptySource // also test for null and empty parameters
//@CsvSource({"Manish", "Neil"})
    @CsvFileSource(resources = "/names.csv")
    void CsvSourceTest(String name) {
        Assertions.assertEquals(8, name.length());
    }

    // use this parameteriezed test when you have multiple values as parameters
    @ParameterizedTest
    @MethodSource()
    void checkLengthOfString(int length, String word) {
        Assertions.assertEquals(length, word.length());
    }
    public static Stream<Arguments> checkLengthOfString() {
        return Stream.of(
                Arguments.arguments(1, "a"),
                Arguments.arguments(3, "door"),
                Arguments.arguments(10, "house")
        );
    }
    @ParameterizedTest
    @MethodSource
    void checkTheNameOfSpartan(Spartan spartan) {
        Assertions.assertEquals("Java", spartan.getCourse());
    }
    public static Stream<Spartan> checkTheNameOfSpartan() {
        return Stream.of(
                new Spartan(1, "Manish", "Java", LocalDate.now()),
                new Spartan(2, "Kieran", "Data", LocalDate.now()),
                new Spartan(3, "David", "C#", LocalDate.now()),
                new Spartan(4, "Dan", "Business", LocalDate.now())
        );
    }
}
