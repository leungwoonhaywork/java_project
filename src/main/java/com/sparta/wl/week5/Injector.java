package com.sparta.wl.week5;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.net.URL;
public class Injector {
    public static ActivityDTO injectDTO(String URL) {
        ActivityDTO activityDTO = new ActivityDTO();
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            activityDTO =  objectMapper.readValue(new URL(URL), ActivityDTO.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return activityDTO;
    }
}
