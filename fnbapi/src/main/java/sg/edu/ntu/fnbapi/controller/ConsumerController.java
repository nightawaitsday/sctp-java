package sg.edu.ntu.fnbapi.controller;

import java.util.ArrayList;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import sg.edu.ntu.fnbapi.entity.Consumer;
import sg.edu.ntu.fnbapi.entity.Favourite;
import sg.edu.ntu.fnbapi.entity.Restaurant;
import sg.edu.ntu.fnbapi.service.ConsumerService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PutMapping;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("/consumers")
public class ConsumerController {

    private static final Logger logger = LoggerFactory.getLogger(ConsumerController.class);

    private ConsumerService consumerService;

    // constructor injection
    @Autowired
    public ConsumerController(ConsumerService consumerService) {
        this.consumerService = consumerService;
    }

    // CRUD

    // Create
    @PostMapping("")
    public ResponseEntity<Consumer> createConsumer(@Valid @RequestBody Consumer consumer) {
        Consumer newConsumer = consumerService.createConsumer(consumer);

        return new ResponseEntity<>(newConsumer, HttpStatus.CREATED);
        
    }

    // Read
    @GetMapping("")
    public ResponseEntity<ArrayList<Consumer>> getAllConsumers() {
        ArrayList<Consumer> allConsumers = consumerService.getAllConsumers();

        logger.info("This is an informational message.");
        logger.error("This is an error message.");

        return new ResponseEntity<>(allConsumers, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Consumer> getConsumer(@PathVariable Long id) {
        Consumer foundConsumer = consumerService.getConsumer(id);

        return new ResponseEntity<>(foundConsumer, HttpStatus.OK);
    }

    // Update
    @PutMapping("/{id}")
    public ResponseEntity<Consumer> updateConsumer(@PathVariable Long id, @RequestBody Consumer consumer) {
        Consumer updatedConsumer = consumerService.updateConsumer(id, consumer);

        return new ResponseEntity<>(updatedConsumer, HttpStatus.OK);
    }

    // Delete
    @DeleteMapping("/{id}")
    public ResponseEntity<Consumer> deleteConsumer(@PathVariable Long id) {
        consumerService.deleteConsumer(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


    @GetMapping("/{id}/favourites")
    public ResponseEntity<List<Restaurant>> getFavouriteRestaurantsByConsumerId(@PathVariable Long id) {
        List<Restaurant> favouriteRestaurants = consumerService.getFavouritesByConsumerId(id);
        return new ResponseEntity<>(favouriteRestaurants, HttpStatus.OK);
    }

    @GetMapping("/{id}/favourites/{restaurantId}")
    public ResponseEntity<Favourite> getFavouriteDetails(
            @PathVariable Long id,
            @PathVariable Long restaurantId) {

        Favourite favouriteDetails = consumerService.getFavouriteDetails(id, restaurantId);

        if (favouriteDetails != null) {
            return new ResponseEntity<>(favouriteDetails, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }



    /** Create Favourite : Like a restaurant **/
    @PostMapping("/{consumerId}/favourites/{restaurantId}")
    public ResponseEntity<Favourite> createFavourite(@PathVariable Long consumerId, @PathVariable Long restaurantId) {
        Favourite newFavourite = consumerService.createFavourite(consumerId, restaurantId);
        return new ResponseEntity<>(newFavourite, HttpStatus.CREATED);
    }

    /** Delete Favourite : Unlike a restaurant **/
    @DeleteMapping("/{consumerId}/favourites/{restaurantId}")
    public ResponseEntity<Void> deleteFavourite(@PathVariable Long consumerId, @PathVariable Long restaurantId) {
        consumerService.deleteFavourite(consumerId, restaurantId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
