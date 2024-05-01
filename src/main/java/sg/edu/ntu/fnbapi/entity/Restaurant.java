package sg.edu.ntu.fnbapi.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "restaurant")
@NoArgsConstructor
@AllArgsConstructor
public class Restaurant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "restaurant_name")
    private String restaurantName;

    @Column(name = "restaurant_type")
    private String restaurantType;

    @Column(name = "address")
    private String address;

    @Column(name = "rating")
    private int rating;

    @Column(name = "cuisine")
    private String cuisine;

    // Add this if you want a one-to-many relationship with Favourite
    // @OneToMany(mappedBy = "restaurant")
    // private List<Favourite> favourites;

    public Restaurant(String restaurantName, String restaurantType) {
        this.restaurantName = restaurantName;
        this.restaurantType = restaurantType;
        this.address = address;
        this.rating = rating;
        this.cuisine = cuisine;
    }
}