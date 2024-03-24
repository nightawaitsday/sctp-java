package sg.edu.ntu.fnbapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import jakarta.transaction.Transactional;
import sg.edu.ntu.fnbapi.entity.Favourite;

public interface FavouriteRepository extends JpaRepository<Favourite, Long> {

  @Transactional
  void deleteByRestaurant_IdAndConsumer_Id(Long restaurantId, Long consumerId);

  /** Check whether the user liked restaurant **/
  boolean existsByRestaurant_IdAndConsumer_Id(Long restaurantId, Long consumerId);

}
