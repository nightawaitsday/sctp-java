package sg.edu.ntu.fnbapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sg.edu.ntu.fnbapi.entity.Restaurant;
import sg.edu.ntu.fnbapi.service.RestaurantService;

import java.util.List;

@RestController
@RequestMapping("/restaurants")
public class RestaurantController {

    private RestaurantService restaurantService;

    @Autowired
    public RestaurantController(RestaurantService restaurantService) {
        this.restaurantService = restaurantService;
    }

    @PostMapping
    public ResponseEntity<Restaurant> createRestaurant(@RequestBody Restaurant restaurant) {
        Restaurant newRestaurant = restaurantService.createRestaurant(restaurant);
        return new ResponseEntity<>(newRestaurant, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Restaurant>> getAllRestaurants() {
        List<Restaurant> allRestaurants = restaurantService.getAllRestaurants();
        return new ResponseEntity<>(allRestaurants, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Restaurant> getRestaurant(@PathVariable Long id) {
        Restaurant restaurant = restaurantService.getRestaurant(id);
        return new ResponseEntity<>(restaurant, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Restaurant> updateRestaurant(@PathVariable Long id, @RequestBody Restaurant restaurant) {
        Restaurant updatedRestaurant = restaurantService.updateRestaurant(id, restaurant);
        return new ResponseEntity<>(updatedRestaurant, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRestaurant(@PathVariable Long id) {
        restaurantService.deleteRestaurant(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}