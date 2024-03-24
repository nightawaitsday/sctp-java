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

    public FavouriteKey(Long restaurantId, Long consumerId) {
        this.restaurantId = restaurantId;
        this.consumerId = consumerId;
    }

    // Getters and setters
}