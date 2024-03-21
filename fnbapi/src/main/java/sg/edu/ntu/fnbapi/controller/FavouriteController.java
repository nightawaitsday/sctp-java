package sg.edu.ntu.fnbapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import sg.edu.ntu.fnbapi.entity.Favourite;
import sg.edu.ntu.fnbapi.service.FavouriteService;

@RestController
@RequestMapping("/favourites")
public class FavouriteController {

    private FavouriteService favouriteService;


    //constructor injection
    @Autowired
    public FavouriteController(FavouriteService favouriteService) {
        this.favouriteService = favouriteService;
    }

    //CRUD

    // Xinyu Amend start 
    // CREATE
    @PostMapping("/favourites")
    public ResponseEntity<Favourite> createFavourite(@Valid @RequestBody Favourite favourite) {
        Favourite newFavourite = favouriteService.createFavourite(favourite);
        return new ResponseEntity<>(newFavourite, HttpStatus.CREATED);
    }
    /* 
     1. Do the favouriteService.createFavourite that should jointhat should return the newFavourite object
     2. To check how to get 2 objects using @Valid or smt? 
     */

    // READ (GET ONE)
    @GetMapping("/{id}")
    public ResponseEntity<Favourite> getFavourite(@PathVariable Long id) {
            Favourite foundFavourite = favouriteService.getFavourite(id);
            return new ResponseEntity<>(foundFavourite, HttpStatus.OK);
    }
}
