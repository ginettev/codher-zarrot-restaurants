package com.tw.zarrot.controller;

import com.tw.zarrot.dto.Restaurant;
import com.tw.zarrot.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RestaurantController {

    @Autowired
    RestaurantService restaurantService;

    @GetMapping("/restaurants")
    public List<Restaurant> restaurants() {
        return restaurantService.get();
    }
}
