package sg.edu.ntu.fnbapi.service;

import java.util.List;
import sg.edu.ntu.fnbapi.entity.Restaurant;

public interface RestaurantService {
    Restaurant createRestaurant(Restaurant restaurant);

    Restaurant getRestaurant(Long id);

    List<Restaurant> getAllRestaurants();

    Restaurant updateRestaurant(Long id, Restaurant restaurant);

    void deleteRestaurant(Long id);

}