package sg.edu.ntu.fnbapi.service;


public interface FavouriteService {

import java.util.ArrayList;
import java.util.List;

import sg.edu.ntu.fnbapi.entity.Favourite;
import sg.edu.ntu.fnbapi.entity.FavouriteKey;
import sg.edu.ntu.fnbapi.entity.Restaurant;

public interface FavouriteService {

    // CREATE
    Favourite createFavourite(Long restaurantId, Long consumerId);

    // DELETE By RESTAURANT ID
    // void deleteFavourite(FavouriteKey id);

    void removeFavoriteFromConsumer(Long restaurantId, Long consumerId);

}
