package sg.edu.ntu.fnbapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.persistence.EntityNotFoundException;
import sg.edu.ntu.fnbapi.entity.Consumer;
import sg.edu.ntu.fnbapi.entity.Favourite;
import sg.edu.ntu.fnbapi.entity.FavouriteKey;
import sg.edu.ntu.fnbapi.entity.Restaurant;
import sg.edu.ntu.fnbapi.exception.ConsumerNotFoundException;
import sg.edu.ntu.fnbapi.exception.RestaurantNotFoundException;
import sg.edu.ntu.fnbapi.repository.ConsumerRepository;
import sg.edu.ntu.fnbapi.repository.FavouriteRepository;
import sg.edu.ntu.fnbapi.repository.RestaurantRepository;

import java.util.List;

@Service
public class RestaurantServiceImpl implements RestaurantService {

    private RestaurantRepository restaurantRepository;
    private ConsumerRepository consumerRepository;
    private FavouriteRepository favouriteRepository;

    @Autowired
    public RestaurantServiceImpl(RestaurantRepository restaurantRepository, FavouriteRepository favouriteRepository,
            ConsumerRepository consumerRepository) {
        this.restaurantRepository = restaurantRepository;
        this.favouriteRepository = favouriteRepository;
        this.consumerRepository = consumerRepository;
    }

    @Override
    public Restaurant createRestaurant(Restaurant restaurant) {
        return restaurantRepository.save(restaurant);
    }

    @Override
    public Restaurant getRestaurant(Long id) {
        return restaurantRepository.findById(id)
                .orElseThrow(() -> new RestaurantNotFoundException(id));
    }

    @Override
    public List<Restaurant> getAllRestaurants() {
        return restaurantRepository.findAll();
    }

    @Override
    public Restaurant updateRestaurant(Long id, Restaurant restaurant) {
        Restaurant existingRestaurant = restaurantRepository.findById(id)
                .orElseThrow(() -> new RestaurantNotFoundException(id));

        existingRestaurant.setRestaurantName(restaurant.getRestaurantName());
        existingRestaurant.setRestaurantType(restaurant.getRestaurantType());
        existingRestaurant.setAddress(restaurant.getAddress());
        existingRestaurant.setRating(restaurant.getRating());
        existingRestaurant.setCuisine(restaurant.getCuisine());

        return restaurantRepository.save(existingRestaurant);
    }

    @Override
    public void deleteRestaurant(Long id) {
        restaurantRepository.deleteById(id);
    }

    /** Create Favourite **/
    @Override
    public boolean createFavourite(Long restaurantId, Long consumerId) {

        // check if the user liked the restaurant
        if (!checkFavourite(restaurantId, consumerId)) {
            // if not liked, create and return true
            Restaurant restaurant = restaurantRepository.findById(restaurantId)
                    .orElseThrow(() -> new RestaurantNotFoundException(restaurantId));
            Consumer consumer = consumerRepository.findById(consumerId)
                    .orElseThrow(() -> new ConsumerNotFoundException(consumerId));

            // Create Favourite Entity
            FavouriteKey favouriteKey = new FavouriteKey(restaurantId, consumerId);
            Favourite favourite = new Favourite(favouriteKey, consumer, restaurant);
            favouriteRepository.save(favourite);

            return true;
        } else {
            // if liked, delete and return false
            // favouriteRepository.deleteByRestaurant_IdAndConsumer_Id(restaurantId,
            // consumerId);
            FavouriteKey favouriteKey = new FavouriteKey(restaurantId, consumerId);
            favouriteRepository.deleteById(favouriteKey);

            return false;
        }
    }

    /** Check Favourite **/
    @Override
    public boolean checkFavourite(Long restaurantId, Long consumerId) {
        FavouriteKey favouriteKey = new FavouriteKey(restaurantId, consumerId);
        return favouriteRepository.existsById(favouriteKey);
    }

}