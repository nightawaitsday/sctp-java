package sg.edu.ntu.fnbapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import sg.edu.ntu.fnbapi.entity.Favourite;
import sg.edu.ntu.fnbapi.service.FavouriteService;

@RestController
@RequestMapping("/favourites")
public class FavouriteController {

    private FavouriteService favouriteService;

    @Autowired
    public FavouriteController(FavouriteService favouriteService) {
        this.favouriteService = favouriteService;
    }

    // CREATE
    // @PostMapping("")
    // public ResponseEntity<Favourite> createFavourite(@RequestParam Long
    // restaurantId, @RequestParam Long consumerId) {
    // Favourite newFavourite = favouriteService.createFavourite(restaurantId,
    // consumerId);
    // return new ResponseEntity<>(newFavourite, HttpStatus.CREATED);
    // }

    // DELETE
    // @DeleteMapping("/{consumerId}/{restaurantId}")
    // public ResponseEntity<Void> removeFavoriteFromConsumer(@PathVariable Long
    // restaurantId,
    // @PathVariable Long consumerId) {
    // favouriteService.removeFavoriteFromConsumer(restaurantId, consumerId);
    // return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    // }
}
