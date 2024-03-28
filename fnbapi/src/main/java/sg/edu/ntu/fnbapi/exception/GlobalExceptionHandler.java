package sg.edu.ntu.fnbapi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;
import java.util.List;


@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ConsumerNotFoundException.class)
    public ResponseEntity<String> handleConsumerNotFoundException(ConsumerNotFoundException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(FavouriteNotFoundException.class)
    public ResponseEntity<String> handleFavouriteNotFoundException(FavouriteNotFoundException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(RestaurantNotFoundException.class)
    public ResponseEntity<String> handleRestaurantNotFoundException(RestaurantNotFoundException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }

    //Validation Exception Handler
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse> handleValidationExceptions(MethodArgumentNotValidException ex) {

        //Get a list of all validation errors from the exception object

        List<ObjectError> validationErrors = ex.getBindingResult().getAllErrors();

        //Create a Stringbuilder to store all error messages
        StringBuilder sb  = new StringBuilder();

        //loop thru
        for(ObjectError error: validationErrors) {
            sb.append(error.getDefaultMessage() + ". ");
        }

        ErrorResponse errorResponse = new ErrorResponse(sb.toString(), LocalDateTime.now());
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);

    } 

  }
