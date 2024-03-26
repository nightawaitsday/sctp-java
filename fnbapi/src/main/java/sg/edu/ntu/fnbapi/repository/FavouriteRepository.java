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

  /** Delete by restaurant and consumer id **/
  @Transactional
  void deleteById(FavouriteKey favouriteKey);

  /** Check whether the favourite already exists **/
  boolean existsById(FavouriteKey favouriteKey);
}
