package sg.edu.ntu.fnbapi.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sg.edu.ntu.fnbapi.entity.Restaurant;
import sg.edu.ntu.fnbapi.exception.RestaurantNotFoundException;
import sg.edu.ntu.fnbapi.repository.RestaurantRepository;

import java.util.List;

@Service
public class RestaurantServiceImpl implements RestaurantService {

    private static final Logger logger = LoggerFactory.getLogger(RestaurantServiceImpl.class);

    private RestaurantRepository restaurantRepository;

    @Autowired
    public RestaurantServiceImpl(RestaurantRepository restaurantRepository) {
        this.restaurantRepository = restaurantRepository;
    }

    @Override
    public Restaurant createRestaurant(Restaurant restaurant) {
        logger.info("Creating restaurant: {}", restaurant);
        return restaurantRepository.save(restaurant);
    }

    @Override
    public Restaurant getRestaurant(Long id) {
        logger.info("Fetching restaurant with ID: {}", id);
        return restaurantRepository.findById(id)
                .orElseThrow(() -> {
                    logger.error("Restaurant not found with ID: {}", id);
                    return new RestaurantNotFoundException(id);
                });
    }

    @Override
    public List<Restaurant> getAllRestaurants() {
        logger.info("Fetching all restaurants");
        return restaurantRepository.findAll();
    }

    @Override
    public Restaurant updateRestaurant(Long id, Restaurant restaurant) {
        logger.info("Updating restaurant with ID: {}", id);
        Restaurant existingRestaurant = restaurantRepository.findById(id)
                .orElseThrow(() -> {
                    logger.error("Restaurant not found with ID: {}", id);
                    return new RestaurantNotFoundException(id);
                });

        existingRestaurant.setRestaurantName(restaurant.getRestaurantName());
        existingRestaurant.setRestaurantType(restaurant.getRestaurantType());
        existingRestaurant.setAddress(restaurant.getAddress());
        existingRestaurant.setRating(restaurant.getRating());
        existingRestaurant.setCuisine(restaurant.getCuisine());

        return restaurantRepository.save(existingRestaurant);
    }

    @Override
    public void deleteRestaurant(Long id) {
        logger.info("Deleting restaurant with ID: {}", id);
        restaurantRepository.deleteById(id);
        logger.info("Restaurant deleted with ID: {}", id);
    }
}
