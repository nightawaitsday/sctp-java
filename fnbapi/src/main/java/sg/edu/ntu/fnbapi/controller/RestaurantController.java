package sg.edu.ntu.fnbapi.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    private static final Logger logger = LoggerFactory.getLogger(RestaurantController.class);

    private RestaurantService restaurantService;

    @Autowired
    public RestaurantController(RestaurantService restaurantService) {
        this.restaurantService = restaurantService;
    }

    @PostMapping
    public ResponseEntity<Restaurant> createRestaurant(@RequestBody Restaurant restaurant) {
        logger.info("Creating restaurant: {}", restaurant);
        Restaurant newRestaurant = restaurantService.createRestaurant(restaurant);
        logger.info("Restaurant created: {}", newRestaurant);
        return new ResponseEntity<>(newRestaurant, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Restaurant>> getAllRestaurants() {
        logger.info("Fetching all restaurants");
        List<Restaurant> allRestaurants = restaurantService.getAllRestaurants();
        logger.info("Fetched {} restaurants", allRestaurants.size());
        return new ResponseEntity<>(allRestaurants, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Restaurant> getRestaurant(@PathVariable Long id) {
        logger.info("Fetching restaurant with ID: {}", id);
        Restaurant restaurant = restaurantService.getRestaurant(id);
        logger.info("Fetched restaurant: {}", restaurant);
        return new ResponseEntity<>(restaurant, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Restaurant> updateRestaurant(@PathVariable Long id, @RequestBody Restaurant restaurant) {
        logger.info("Updating restaurant with ID: {}", id);
        Restaurant updatedRestaurant = restaurantService.updateRestaurant(id, restaurant);
        logger.info("Restaurant updated: {}", updatedRestaurant);
        return new ResponseEntity<>(updatedRestaurant, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRestaurant(@PathVariable Long id) {
        logger.info("Deleting restaurant with ID: {}", id);
        restaurantService.deleteRestaurant(id);
        logger.info("Restaurant deleted with ID: {}", id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
