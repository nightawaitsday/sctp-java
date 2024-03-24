package sg.edu.ntu.fnbapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import sg.edu.ntu.fnbapi.entity.Favourite;

import java.util.List;


public interface FavouriteRepository extends JpaRepository<Favourite, Long> {
        List<Favourite> findByUserId(Long userId);
}
    

