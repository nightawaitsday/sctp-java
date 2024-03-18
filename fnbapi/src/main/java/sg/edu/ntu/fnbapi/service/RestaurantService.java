package sg.edu.ntu.fnbapi.service;

import java.util.ArrayList;

import sg.edu.ntu.fnbapi.entity.Restaurant;

public interface RestaurantService {

    Restaurant getRestaurant(Long id);
    ArrayList<Restaurant> getAllRestaurants();
} 
