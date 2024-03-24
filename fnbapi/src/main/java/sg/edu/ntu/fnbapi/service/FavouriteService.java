package sg.edu.ntu.fnbapi.service;

import java.util.ArrayList;

import sg.edu.ntu.fnbapi.entity.Favourite;

public interface FavouriteService {

    // CREATE
    Favourite createFavourite(Long restaurantId, Long consumerId);

    // DELETE By RESTAURANT ID
    void deleteFavourite(Long id);

    // READ 1
    FavouriteDetails getFavouriteDetails(Long id, Long restaurantId);


    // READ 2
    FavouriteRestauratList getFavouriteRestaurantList (Long id);  


    // Todo: update 
}
