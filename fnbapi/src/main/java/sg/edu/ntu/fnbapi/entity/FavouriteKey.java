package sg.edu.ntu.fnbapi.entity;

import java.io.Serializable;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Embeddable
public class FavouriteKey implements Serializable {
    private Long restaurantId;
    private Long consumerId;

    public FavouriteKey() {
        // Default constructor
    }

    public FavouriteKey(Long consumerId, Long restaurantId) {
        this.consumerId = consumerId;
        this.restaurantId = restaurantId;
    }

    // Getters and setters
}