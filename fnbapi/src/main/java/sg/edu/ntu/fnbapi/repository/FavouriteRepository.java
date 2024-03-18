package sg.edu.ntu.fnbapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import sg.edu.ntu.fnbapi.entity.Favourite;

public interface FavouriteRepository extends JpaRepository<Favourite, Long>{

    
} 
