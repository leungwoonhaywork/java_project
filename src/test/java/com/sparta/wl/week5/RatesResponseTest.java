package com.sparta.wl.week5;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;

public class RatesResponseTest {
    static RatesResponse response;
    List<Method> methodList = new ArrayList<>();

    @BeforeAll
    static void setUpAll(TestInfo testInfo) {
        System.out.println(testInfo.getDisplayName() + " has started");
        System.out.println(testInfo.getClass());
    }

    @BeforeEach
    void setUp(TestInfo testInfo) {
        System.out.println(testInfo.getDisplayName() + " is running");
        ObjectMapper mapper = new ObjectMapper();
        try {
            response = mapper.readValue(new File("src/main/resources/week5/rates.json"), RatesResponse.class);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (StreamReadException e) {
            e.printStackTrace();
        } catch (DatabindException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Rates rates = new Rates();
        Class cls = rates.getClass();
        Method[] methods = cls.getMethods();
        for (int i = 0; i < cls.getMethods().length; i ++) {
            if (methods[i].getGenericReturnType() == Integer.class || methods[i].getGenericReturnType() == Double.class)
            methodList.add(methods[i]);
        }
    }

    @Test
    @DisplayName("Test timestamp must > 0")
    void testTimestampPositive() {
        Assertions.assertTrue(response.getTimestamp() > 0);
    }

    @Nested
    @DisplayName("Test Date")
    class testDate {
        @Test
        @DisplayName("Test Date cannot be null")
        void testDateExist() {
            Assertions.assertTrue(response.getDate() != null);
        }

        @Test
        @DisplayName("Test Date format must be yyyy-mm-dd")
        void testDateFormat() {
            Assertions.assertTrue(response.getDate().matches("\\d{4}-\\d{1,2}-\\d{1,2}"));
        }
    }

    @Nested
    @DisplayName("Test Base")
    class testBase {
        @Test
        @DisplayName("Test Base cannot be null")
        void testBaseExist() {
            Assertions.assertTrue(response.getBase() != null);
        }

        @Test
        @DisplayName("Test Base length must be 3")
        void testBaseLength() {

            Assertions.assertTrue(response.getBase().length() == 3);
        }
    }

    @Nested
    @DisplayName("Test Rates")
    class testRates {
        @Test
        @DisplayName("Test total number of rates")
        void testNumberOfRates() {
            Assertions.assertEquals(168, methodList.size());
        }

        @ParameterizedTest
        @MethodSource("testListRates")
        @DisplayName("Test Rates must > 0")
        void testBaseLength(Double rates) {
            Assertions.assertTrue(rates > 0);
        }

        static List<Double> testListRates() {
            List<Double> rateList = new ArrayList<>();
            ObjectMapper mapper = new ObjectMapper();
            try {
                response = mapper.readValue(new File("src/main/resources/week5/rates.json"), RatesResponse.class);
            } catch (IOException e) {
                e.printStackTrace();
            }
            Rates rates = new Rates();
            Class cls = rates.getClass();
            Method[] methods = cls.getMethods();
            for (int i = 0; i < cls.getMethods().length; i ++) {
                if (methods[i].getGenericReturnType() == Integer.class || methods[i].getGenericReturnType() == Double.class) {
                    try {
                        Object o = methods[i].invoke(response.getRates());
                        rateList.add(Double.valueOf(o.toString()));
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    } catch (InvocationTargetException e) {
                        e.printStackTrace();
                    }
                }
            }
            return rateList;
        }
    }

    @AfterAll
    static void teamDownAll(TestInfo testInfo) {
        System.out.println(testInfo.getDisplayName() + " has finished");
    }
}
