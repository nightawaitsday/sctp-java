package sg.edu.ntu.fnbapi.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "favourite")
@NoArgsConstructor
@AllArgsConstructor
public class Favourite {

    @EmbeddedId
    @Column(name = "id")
    private FavouriteKey id;

    @ManyToOne(optional = false)
    @MapsId("restaurantId")
    @JoinColumn(name = "restaurant_id", referencedColumnName = "id")
    private Restaurant restaurant;

    @ManyToOne(optional = false)
    @MapsId("consumerId")
    @JoinColumn(name = "consumer_id", referencedColumnName = "id")
    private Consumer consumer;

    @JsonIgnore
    public Restaurant getRestaurant() {
        return restaurant;
    }

    @JsonIgnore
    public Consumer getConsumer() {
        return consumer;
    }

    /** Create Entity **/
    public Favourite(FavouriteKey id, Consumer consumer, Restaurant restaurant) {
        this.id = id;
        this.consumer = consumer;
        this.restaurant = restaurant;
    }
}
