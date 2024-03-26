package sg.edu.ntu.fnbapi.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;
import sg.edu.ntu.fnbapi.entity.Consumer;
import sg.edu.ntu.fnbapi.entity.Favourite;
import sg.edu.ntu.fnbapi.entity.Restaurant;

@Component
public class DataLoader {
    private ConsumerRepository consumerRepository;
    private RestaurantRepository restaurantRepository;
    private FavouriteRepository favouriteRepository;

    @Autowired
    public DataLoader(ConsumerRepository consumerRepository, RestaurantRepository restaurantRepository
            , FavouriteRepository favouriteRepository
            ) {
        this.consumerRepository = consumerRepository;
        this.restaurantRepository = restaurantRepository;
        this.favouriteRepository = favouriteRepository;
    }

    @PostConstruct
    public void loadData() {
        // clear database first
        consumerRepository.deleteAll();
        restaurantRepository.deleteAll();
        favouriteRepository.deleteAll();

        // load data here

        consumerRepository.save(new Consumer("Mary", "Tan", "marytan@outlook.com"));
        consumerRepository.save(new Consumer("Jimmy", "Lee", "jimlee@gmail.com"));
        consumerRepository.save(new Consumer("John", "Lim", "jlim@gmail.com"));

        restaurantRepository.save(new Restaurant("Pasta Bar", "Italian"));
        restaurantRepository.save(new Restaurant("The Golden Duck", "Chinese"));
        restaurantRepository.save(new Restaurant("Dim Sum Place", "Chinese"));
        restaurantRepository.save(new Restaurant("Kava", "Western"));

    }
}
