package sg.edu.ntu.fnbapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import jakarta.persistence.EntityNotFoundException;
import sg.edu.ntu.fnbapi.entity.Consumer;
import sg.edu.ntu.fnbapi.entity.Favourite;
import sg.edu.ntu.fnbapi.entity.FavouriteKey;
import sg.edu.ntu.fnbapi.entity.Restaurant;
import sg.edu.ntu.fnbapi.exception.ConsumerNotFoundException;
import sg.edu.ntu.fnbapi.exception.FavouriteNotFoundException;
import sg.edu.ntu.fnbapi.repository.ConsumerRepository;
import sg.edu.ntu.fnbapi.repository.FavouriteRepository;
import sg.edu.ntu.fnbapi.repository.RestaurantRepository;

@Primary
@Service
public class FavouriteServiceImpl implements FavouriteService {

    private FavouriteRepository favouriteRepository;
    private RestaurantRepository restaurantRepository;
    private ConsumerRepository consumerRepository;

    @Autowired
    public FavouriteServiceImpl(FavouriteRepository favouriteRepository, RestaurantRepository restaurantRepository,
            ConsumerRepository consumerRepository) {

        this.favouriteRepository = favouriteRepository;
        this.restaurantRepository = restaurantRepository;
        this.consumerRepository = consumerRepository;
    }

    @Override
    public void removeFavoriteFromConsumer(Long restaurantId, Long consumerId) {
        // Fetch the Consumer entity from the database
        Consumer consumer = consumerRepository.findById(consumerId)
                .orElseThrow(() -> new EntityNotFoundException("Consumer not found with id: " + consumerId));

        // Remove the favorite with the specified restaurantId from the Consumer's
        // favorite list
        consumer.getFavourites().removeIf(favourite -> favourite.getRestaurant().getId().equals(restaurantId));

        // Update the Consumer entity in the database
        consumerRepository.save(consumer);

    }

}