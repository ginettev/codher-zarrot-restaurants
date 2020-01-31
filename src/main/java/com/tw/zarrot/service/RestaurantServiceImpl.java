package com.tw.zarrot.service;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.tw.zarrot.dto.Restaurant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.util.List;

@Component
public class RestaurantServiceImpl implements RestaurantService {

    @Autowired
    Gson gson;

    @Override
    public List<Restaurant> get() {
        InputStreamReader reader = null;
        Type type = new TypeToken<List<Restaurant>>() {
        }.getType();
        try {
            Resource resource = new ClassPathResource("restaurants.json");
            reader = new InputStreamReader(resource.getInputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return gson.fromJson(reader, type);
    }
}
