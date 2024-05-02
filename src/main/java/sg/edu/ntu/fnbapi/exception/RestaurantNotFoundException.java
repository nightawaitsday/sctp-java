package sg.edu.ntu.fnbapi.exception;

public class RestaurantNotFoundException extends RuntimeException {
    public RestaurantNotFoundException(Long id) {
        super("Could not find restaurant with id: " + id);
    }
}