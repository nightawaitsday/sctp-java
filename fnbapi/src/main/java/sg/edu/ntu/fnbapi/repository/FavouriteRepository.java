package sg.edu.ntu.fnbapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import jakarta.transaction.Transactional;
import sg.edu.ntu.fnbapi.entity.Favourite;
import sg.edu.ntu.fnbapi.entity.FavouriteKey;

import java.util.List;
    

public interface FavouriteRepository extends JpaRepository<Favourite, FavouriteKey> {

  // List<Favourite> findByUserId(Long userId);

  Favourite findByIdAndRestaurantId(Long id, Long restaurantId);

  // FavouriteDetails getFavouriteDetails(Long id, Long restaurantId);


  // =========== After change to composite key ==============
  /** Delete by restaurant and consumer id **/
  @Transactional
  void deleteById(FavouriteKey favouriteKey);

  /** Check whether the user liked restaurant **/
  boolean existsById(FavouriteKey favouriteKey);

  // =========== Before change to composite key ==============
  /** If we don't use composite key, can use below 2 methods **/
  /** Delete by restaurant and consumer id **/
  // @Transactional
  // void deleteByRestaurant_IdAndConsumer_Id(Long restaurantId, Long consumerId);

  /** Check whether the user liked restaurant **/
  // boolean existsByRestaurant_IdAndConsumer_Id(Long restaurantId, Long
  // consumerId);

}
