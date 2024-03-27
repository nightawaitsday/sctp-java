package sg.edu.ntu.fnbapi.exception;

public class FavouriteNotFoundException extends RuntimeException {
    public FavouriteNotFoundException() {
        super("Favourite not found");
    }
}