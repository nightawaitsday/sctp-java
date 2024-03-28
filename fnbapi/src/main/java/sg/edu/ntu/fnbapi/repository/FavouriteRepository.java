package sg.edu.ntu.fnbapi.repository;

 import org.springframework.data.jpa.repository.JpaRepository;

 import jakarta.transaction.Transactional;
 import sg.edu.ntu.fnbapi.entity.Favourite;
 import sg.edu.ntu.fnbapi.entity.FavouriteKey;

 public interface FavouriteRepository extends JpaRepository<Favourite, FavouriteKey> {


   /** Delete by restaurant and consumer id **/
   @Transactional
   void deleteById(FavouriteKey favouriteKey);

   /** Check whether the favourite already exists **/
      boolean existsById(FavouriteKey favouriteKey);
 }
