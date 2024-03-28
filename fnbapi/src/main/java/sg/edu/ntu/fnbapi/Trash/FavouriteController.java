// package sg.edu.ntu.fnbapi.controller;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.http.HttpStatus;
// import org.springframework.http.ResponseEntity;
// import org.springframework.web.bind.annotation.DeleteMapping;
// import org.springframework.web.bind.annotation.PathVariable;
// import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RequestParam;
// import org.springframework.web.bind.annotation.RestController;
// import org.springframework.web.bind.annotation.GetMapping;

// import sg.edu.ntu.fnbapi.entity.Favourite;
// import sg.edu.ntu.fnbapi.service.FavouriteService;

// @RestController
// @RequestMapping("/favourites")
// public class FavouriteController {

//     private FavouriteService favouriteService;

//     @Autowired
//     public FavouriteController(FavouriteService favouriteService) {
//         this.favouriteService = favouriteService;
//     }

//     // CRUD

//     // Assume consumer id and restaurant id are present because i am favouriting at
//     // the resturant details
//     // get url (front end provides)
//     // http://localhost:8080/restaurant-details?consumerId=1&restaurantId=123
//     // getFavouriteDetails method to do
//     // READ
//     // @GetMapping("/consumer/{id}/favourites/{restaurantId}")
//     // public ResponseEntity<FavouriteDetails> getFavouriteDetails(
//     // @PathVariable Long id,
//     // @PathVariable Long restaurantId) {

//     // FavouriteDetails FavouriteDetails = FavouriteService.getFavouriteDetails(id,
//     // restaurantId);

//     // if (FavouriteDetails != null) {
//     // // If the favourite details are found, return them with HTTP status code 200
//     // (OK)
//     // return new ResponseEntity<>(FavouriteDetails, HttpStatus.OK);
//     // } else {
//     // // If the favourite details are not found, return HTTP status code 404 (Not
//     // Found)
//     // return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//     // }
//     // }

//     // READ 1 REFACTOR  
//     // @GetMapping("/consumer/{id}/favourites/{restaurantId}")
//     // public ResponseEntity<Favourite> getFavouriteDetails(
//     //         @PathVariable Long id,
//     //         @PathVariable Long restaurantId) {

//     //     Favourite favouriteDetails = favouriteService.getFavouriteDetails(id, restaurantId);

//     //     if (favouriteDetails != null) {
//     //         return new ResponseEntity<>(favouriteDetails, HttpStatus.OK);
//     //     } else {
//     //         return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//     //     }
//     // }

//     // // READ 2 RETRIEVE ALL FAVOURITES FOR THE USERID
//     // // get the restaurant ids then use that to retrieve from restaurant and
//     // return api a list of RESTAURANTS
//     // @GetMapping("/consumer/{id}/favourites")
//     // public ResponseEntity<List<FavouriteRestauratList>>
//     // getFavouriteRestaurantList(
//     // @PathVariable Long id) {

//     // List<Favourite> favouriteList = favouriteService.getFavouritesByUserId(id);

//     // List<FavouriteRestaurantList> favouriteRestaurantList =
//     // favouriteService.getFavouriteRestaurantList(id);

//     // if (favouriteRestaurantList != null) {
//     // return new ResponseEntity<>(favouriteList, HttpStatus.OK);
//     // } else {
//     // return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//     // }

//     // }

// }
