package sg.edu.ntu.fnbapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sg.edu.ntu.fnbapi.entity.Restaurant;

public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {
}