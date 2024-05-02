package sg.edu.ntu.fnbapi.exception;

public class ConsumerNotFoundException extends RuntimeException{
    public ConsumerNotFoundException(Long id) {
        super("Could not find consumer with id: " + id);
    }
}
