package com.sparta.wl.week5;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sparta.wl.FileReader;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;

public class JSONTask {
    public static void main(String[] args) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            RatesResponse response = mapper.readValue(new File("src/main/resources/week5/rates.json"), RatesResponse.class);

            System.out.println(response.getRates().getHKD());

            Rates rates = new Rates();

            //Class cls = rates.getClass();

            Class cls = response.getClass();

            cls = response.getRates().getClass();

            Method[] methods = cls.getMethods();


            for (Method method:methods)
                if (method.getGenericReturnType() == Integer.class || method.getGenericReturnType() == Double.class) {
                    //method.setAccessible(true);
                    Object o = method.invoke(response.getRates());
                    System.out.println(o);
                }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
