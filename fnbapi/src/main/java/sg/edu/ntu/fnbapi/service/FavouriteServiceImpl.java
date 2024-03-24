package sg.edu.ntu.fnbapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import sg.edu.ntu.fnbapi.repository.FavouriteRepository;

@Primary
@Service
public class FavouriteServiceImpl implements FavouriteService {

    private FavouriteRepository favouriteRepository;

    @Autowired
    public FavouriteServiceImpl(FavouriteRepository favouriteRepository) {

        this.favouriteRepository = favouriteRepository;

    }
}