package sg.edu.ntu.fnbapi.exception;

public class FavouriteAlreadyExistsException extends RuntimeException {
  public FavouriteAlreadyExistsException(Long consumerId, Long restaurantId) {
    super("Favourite already exists for consumerId: " + consumerId + " and restaurantId: " + restaurantId);
  }
}
