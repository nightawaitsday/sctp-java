package sg.edu.ntu.fnbapi.service;

import java.util.ArrayList;

import sg.edu.ntu.fnbapi.entity.Favourite;

public interface FavouriteService {

    Favourite createFavourite(Favourite favourite);
    Favourite getFavourite(Long id);
    // ArrayList<Favourite> getAllFavourites();
    // void deleteFavourite(Long id);
} 
