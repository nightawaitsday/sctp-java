package sg.edu.ntu.fnbapi.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import sg.edu.ntu.fnbapi.entity.Consumer;
import sg.edu.ntu.fnbapi.entity.Favourite;
import sg.edu.ntu.fnbapi.entity.FavouriteKey;
import sg.edu.ntu.fnbapi.entity.Restaurant;
import sg.edu.ntu.fnbapi.exception.ConsumerNotFoundException;
import sg.edu.ntu.fnbapi.exception.FavouriteAlreadyExistsException;
import sg.edu.ntu.fnbapi.exception.FavouriteNotFoundException;
import sg.edu.ntu.fnbapi.exception.RestaurantNotFoundException;
import sg.edu.ntu.fnbapi.repository.ConsumerRepository;
import sg.edu.ntu.fnbapi.repository.FavouriteRepository;
import sg.edu.ntu.fnbapi.repository.RestaurantRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Primary
@Service
public class ConsumerServiceImpl implements ConsumerService {

    private static final Logger logger = LoggerFactory.getLogger(ConsumerServiceImpl.class);

    private ConsumerRepository consumerRepository;
    private FavouriteRepository favouriteRepository;
    private RestaurantRepository restaurantRepository;

    // implement ConsumerService methods

    @Autowired
    public ConsumerServiceImpl(ConsumerRepository consumerRepository, FavouriteRepository favouriteRepository,
            RestaurantRepository restaurantRepository) {
        this.consumerRepository = consumerRepository;
        this.favouriteRepository = favouriteRepository;
        this.restaurantRepository = restaurantRepository;
    }

    @Override
    public Consumer createConsumer(Consumer consumer) {
        Consumer newConsumer = consumerRepository.save(consumer);
        return newConsumer;
    }

    @Override
    public Consumer getConsumer(Long id) {

        return consumerRepository.findById(id).orElseThrow(() -> new ConsumerNotFoundException(id));
    }

    @Override
    public ArrayList<Consumer> getAllConsumers() {
        List<Consumer> allConsumers = consumerRepository.findAll();
        return (ArrayList<Consumer>) allConsumers;
    }

    @Override
    public Consumer updateConsumer(Long id, Consumer consumer) {
        // retrieve from database
        Consumer consumerToUpdate = consumerRepository.findById(id)
                .orElseThrow(() -> new ConsumerNotFoundException(id));

        // update retrieved consumer
        consumerToUpdate.setFirstName(consumer.getFirstName());
        consumerToUpdate.setLastName(consumer.getLastName());
        consumerToUpdate.setEmail(consumer.getEmail());

        // Save consumer back to database
        return consumerRepository.save(consumerToUpdate);

    }

    @Override
    public void deleteConsumer(Long id) {
        consumerRepository.deleteById(id);
    }

    @Override
    public List<Restaurant> getFavouritesByConsumerId(Long consumerId) {
        // Fetch the Consumer entity from the database
        logger.info("Get for consumer id: " + consumerId);
        Consumer consumer = consumerRepository.findById(consumerId)
                .orElseThrow(() -> new IllegalArgumentException("Consumer not found with id: " + consumerId));

        // Retrieve the list of favorite restaurants associated with the Consumer
        List<Restaurant> favouriteRestaurants = new ArrayList<>();

        for (Favourite favourite : consumer.getFavourites()) {
            favouriteRestaurants.add(favourite.getRestaurant());
            logger.info("Favorite: {}, Restaurant: {}", favourite, favouriteRestaurants);
        }
        return favouriteRestaurants;

    }

    
    // GET RESTAURANT FOR CONSUMER ID
    @Override
    public Favourite getFavouriteDetails(Long id, Long restaurantId) {
        logger.info("Get for consumer id: " + id + " and restaurant id: " + restaurantId);
        Consumer consumer = consumerRepository.findById(id)
                .orElseThrow(() -> new ConsumerNotFoundException(id));

        // Fetch the associated restaurant
        Restaurant restaurant = restaurantRepository.findById(restaurantId)
                .orElseThrow(() -> new RestaurantNotFoundException(restaurantId));

        logger.info("Consumer id is: "+ id + " and restaurant id: " + restaurantId);

        if (checkFavourite(id, restaurantId)) {
            FavouriteKey favouriteKey = new FavouriteKey(id, restaurantId);
            return new Favourite(favouriteKey, consumer, restaurant);
        } else {
            FavouriteKey favouriteKey = new FavouriteKey ();
            return new Favourite(favouriteKey, consumer, restaurant);
        }

    }

    /** Create Favourite **/
    @Override
    public Favourite createFavourite(Long consumerId, Long restaurantId) {
        logger.info("Entering createFavourite method with consumer Id: " + consumerId + " and restaurant Id: "
                + restaurantId);

        // check if this favourite exists
        if (!checkFavourite(consumerId, restaurantId)) {
            // if not liked, create
            Consumer consumer = consumerRepository.findById(consumerId)
                    .orElseThrow(() -> new ConsumerNotFoundException(consumerId));
            Restaurant restaurant = restaurantRepository.findById(restaurantId)
                    .orElseThrow(() -> new RestaurantNotFoundException(restaurantId));

            // Create Favourite Entity
            FavouriteKey favouriteKey = new FavouriteKey(consumerId, restaurantId);
            Favourite newFavourite = new Favourite(favouriteKey, consumer, restaurant);

            logger.info("Calling favourite repository");
            favouriteRepository.save(newFavourite);
            logger.info("Exisiting createFavourite method");
            return newFavourite;
        } else {
            throw new FavouriteAlreadyExistsException(consumerId, restaurantId);
        }
    }

    /** Delete Favourite **/
    @Override
    public void deleteFavourite(Long consumerId, Long restaurantId) {
        FavouriteKey favouriteKey = new FavouriteKey(consumerId, restaurantId);
        // check if this favourite exists
        if (checkFavourite(consumerId, restaurantId)) {
            favouriteRepository.deleteById(favouriteKey);
        } else {
            throw new FavouriteNotFoundException(consumerId, restaurantId);
        }
    }

    /** Check Favourite **/
    @Override
    public boolean checkFavourite(Long consumerId, Long restaurantId) {
        FavouriteKey favouriteKey = new FavouriteKey(consumerId, restaurantId);
        return favouriteRepository.existsById(favouriteKey);
    }

}
