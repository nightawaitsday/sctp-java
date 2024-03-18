package sg.edu.ntu.fnbapi.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import sg.edu.ntu.fnbapi.entity.Favourite;
import sg.edu.ntu.fnbapi.exception.FavouriteNotFoundException;
import sg.edu.ntu.fnbapi.repository.FavouriteRepository;

@Primary
@Service
public class FavouriteServiceImpl implements FavouriteService{

    private FavouriteRepository favouriteRepository;

    @Autowired
    public FavouriteServiceImpl(FavouriteRepository favouriteRepository) {
        this.favouriteRepository = favouriteRepository;
    }

    //implement FavouriteService methods

    public Favourite createFavourite(Favourite favourite) {
        Favourite newInteraction = favouriteRepository.save(favourite);
        return newInteraction;
    }

    public Favourite getFavourite(Long id){
        Optional<Favourite> optionalFavourite = favouriteRepository.findById(id);
        if(optionalFavourite.isPresent()) {
            Favourite foundFavourite = optionalFavourite.get();
            return foundFavourite;
        }
        throw new FavouriteNotFoundException();
    }
}
