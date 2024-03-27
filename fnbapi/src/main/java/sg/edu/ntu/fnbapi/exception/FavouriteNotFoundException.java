package sg.edu.ntu.fnbapi.exception;

public class FavouriteNotFoundException extends RuntimeException {
  public FavouriteNotFoundException(Long consumerId, Long restaurantId) {
    super("Favourite not found for consumerId: " + consumerId + " and restaurantId: " + restaurantId);
  }
}
