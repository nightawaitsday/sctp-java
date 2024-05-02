// package sg.edu.ntu.fnbapi.service;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.context.annotation.Primary;
// import org.springframework.stereotype.Service;
// import java.util.ArrayList;
// import java.util.List;
// import java.util.Optional;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.context.annotation.Primary;
// import org.springframework.stereotype.Service;

// import jakarta.persistence.EntityNotFoundException;
// import sg.edu.ntu.fnbapi.entity.Consumer;
// import sg.edu.ntu.fnbapi.entity.Favourite;
// import sg.edu.ntu.fnbapi.entity.FavouriteKey;
// import sg.edu.ntu.fnbapi.entity.Restaurant;
// import sg.edu.ntu.fnbapi.exception.ConsumerNotFoundException;
// import sg.edu.ntu.fnbapi.exception.RestaurantNotFoundException;
// import sg.edu.ntu.fnbapi.repository.ConsumerRepository;
// import sg.edu.ntu.fnbapi.repository.FavouriteRepository;
// import sg.edu.ntu.fnbapi.repository.RestaurantRepository;

// @Primary
// @Service
// public class FavouriteServiceImpl implements FavouriteService {

//     private FavouriteRepository favouriteRepository;
//     private RestaurantRepository restaurantRepository;
//     private ConsumerRepository consumerRepository;

//     @Autowired
//     public FavouriteServiceImpl(FavouriteRepository favouriteRepository, RestaurantRepository restaurantRepository,
//             ConsumerRepository consumerRepository) {

//         this.favouriteRepository = favouriteRepository;
//         this.restaurantRepository = restaurantRepository;
//         this.consumerRepository = consumerRepository;
//     }

//     // // CREATE
//     // public Favourite createFavourite(Long restaurantId, Long consumerId) {
//     // Restaurant restaurant = restaurantRepository.findById(restaurantId)
//     // .orElseThrow(() -> new EntityNotFoundException("Restaurant not found with id:
//     // " + restaurantId));
//     // Consumer consumer = consumerRepository.findById(consumerId)
//     // .orElseThrow(() -> new ConsumerNotFoundException(consumerId));

//     // Favourite favourite = new Favourite();
//     // favourite.setRestaurant(restaurant);
//     // favourite.setConsumer(consumer);

//     // return favouriteRepository.save(favourite);
//     // }

//     // @Override
//     // public Favourite getFavouriteDetails(Long id, Long restaurantId) {

//     //     Consumer consumer = consumerRepository.findById(id)
//     //             .orElseThrow(() -> new ConsumerNotFoundException(id));

//     //     // Fetch the associated restaurant
//     //     Restaurant restaurant = restaurantRepository.findById(restaurantId)
//     //             .orElseThrow(() -> new RestaurantNotFoundException(restaurantId));

//     //     FavouriteKey favouriteKey = new FavouriteKey(id, restaurantId);

//     //     return new Favourite(favouriteKey, consumer, restaurant);
//     // }

//     // // READ 1
//     // @Override
//     // public FavouriteDetails getFavouriteDetails(Long id, Long restaurantId) {
//     // // get the Favourite details
//     // Optional<Favourite> optionalFavourite =
//     // favouriteRepository.findByIdAndRestaurantId(id, restaurantId);
//     // Favourite favourite = optionalFavourite.orElseThrow(() -> new
//     // FavouriteNotFoundException(id, restaurantId));
//     // return new FavouriteDetails(favourite.getId(), favourite.getRestaurantId());
//     // // return new FavouriteDetails(id, restaurantId);
//     // }

//     // READ 2
//     // @Override
//     // public List<FavouriteRestaurantList> getFavouriteRestaurantList(Long id) {

//     // List<Favourite> favouriteList = favouriteRepository.findByUserId(id);

//     // // List<Favourite> FavouriteList = favouriteRepository.findAll();
//     // ArrayList<FavouriteRestaurantList> favouriteRestaurantList = new
//     // ArrayList<>();

//     // for (Favourite favourite : favouriteList) {
//     // Long restaurantId = favourite.getRestaurantId();
//     // Restaurant restaurant = restaurantRepository.findById(restaurantId)
//     // .orElseThrow(() -> new RestaurantNotFoundException(restaurantId));
//     // favouriteRestaurantList.add(new FavouriteRestaurantList(favourite,
//     // restaurant));
//     // }

//     // return favouriteRestaurantList;
//     // }

//     // @Override
//     // public void removeFavoriteFromConsumer(Long restaurantId, Long consumerId) {
//     // // Fetch the Consumer entity from the database
//     // Consumer consumer = consumerRepository.findById(consumerId)
//     // .orElseThrow(() -> new EntityNotFoundException("Consumer not found with id: "
//     // + consumerId));

//     // // Remove the favorite with the specified restaurantId from the Consumer's
//     // // favorite list
//     // consumer.getFavourites().removeIf(favourite ->
//     // favourite.getRestaurant().getId().equals(restaurantId));

//     // // Update the Consumer entity in the database
//     // consumerRepository.save(consumer);

//     // }

// }