package sg.edu.ntu.fnbapi.service;

import java.util.ArrayList;
import java.util.List;

import sg.edu.ntu.fnbapi.entity.Consumer;
import sg.edu.ntu.fnbapi.entity.Favourite;
import sg.edu.ntu.fnbapi.entity.Restaurant;

public interface ConsumerService {
    // ArrayList<Consumer> searchConsumers(String firstName);
    Consumer createConsumer(Consumer consumer);

    Consumer getConsumer(Long id);

    ArrayList<Consumer> getAllConsumers();

    Consumer updateConsumer(Long id, Consumer consumer);

    void deleteConsumer(Long id);

    Favourite addFavouriteToConsumer(Long id, Favourite favourite);

    // GET FAVOURITES LIST
    List<Restaurant> getFavouritesByConsumerId(Long consumerId);

    // GET REST FOR ID 
    Favourite getFavouriteDetails(Long id, Long restaurantId);


    /** Create Favourite **/
    Favourite createFavourite(Long consumerId, Long restaurantId);

    /** Delete Favourite **/
    void deleteFavourite(Long consumerId, Long restaurantId);

    /** Check Favourite **/
    boolean checkFavourite(Long consumerId, Long restaurantId);
}
