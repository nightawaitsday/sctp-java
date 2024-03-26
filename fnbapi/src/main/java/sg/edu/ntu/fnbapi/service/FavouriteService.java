package sg.edu.ntu.fnbapi.service;

import java.util.ArrayList;
import java.util.List;

import sg.edu.ntu.fnbapi.entity.Favourite;
import sg.edu.ntu.fnbapi.entity.Restaurant;

public interface FavouriteService {

    void removeFavoriteFromConsumer(Long restaurantId, Long consumerId);

    // DELETE By RESTAURANT ID
    // void deleteFavourite(Long id);

    // READ 1
    Favourite getFavouriteDetails(Long id, Long restaurantId);


    // READ 2
    // FavouriteRestauratList getFavouriteRestaurantList (Long id);  


    // Todo: update 
}
