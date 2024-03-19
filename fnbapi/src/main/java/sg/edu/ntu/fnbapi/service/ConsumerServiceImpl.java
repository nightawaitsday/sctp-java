package sg.edu.ntu.fnbapi.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import sg.edu.ntu.fnbapi.entity.Consumer;
import sg.edu.ntu.fnbapi.entity.Favourite;
import sg.edu.ntu.fnbapi.exception.ConsumerNotFoundException;
import sg.edu.ntu.fnbapi.repository.ConsumerRepository;
import sg.edu.ntu.fnbapi.repository.FavouriteRepository;

@Primary
@Service
public class ConsumerServiceImpl implements ConsumerService{
    
    private ConsumerRepository consumerRepository;
    private FavouriteRepository favouriteRepository;

    //implement ConsumerService methods

    @Autowired
    public ConsumerServiceImpl(ConsumerRepository consumerRepository, FavouriteRepository favouriteRepository) {
        this.consumerRepository = consumerRepository;
        this.favouriteRepository = favouriteRepository;
    }

    @Override
    public Consumer createConsumer(Consumer consumer) {
        Consumer newConsumer = consumerRepository.save(consumer);
        return newConsumer;
    }

    @Override
    public Consumer getConsumer(Long id) {

        return consumerRepository.findById(id).orElseThrow(() -> 
        new ConsumerNotFoundException(id));
    }

    @Override
    public ArrayList<Consumer> getAllConsumers() {
        List<Consumer> allConsumers = consumerRepository.findAll();
        return (ArrayList<Consumer>) allConsumers;
    }

    @Override
    public Consumer updateConsumer(Long id, Consumer consumer) {
        //retrieve from database
        Consumer consumerToUpdate = consumerRepository.findById(id).orElseThrow(() -> new ConsumerNotFoundException(id));

        //update retrieved consumer
        consumerToUpdate.setFirstName(consumer.getFirstName());
        consumerToUpdate.setLastName(consumer.getLastName());
        consumerToUpdate.setEmail(consumer.getEmail());

        //Save consumer back to database
        return consumerRepository.save(consumerToUpdate);

    }

    @Override
    public void deleteConsumer(Long id) {
        consumerRepository.deleteById(id);
    }

    @Override
    public Favourite addFavouriteToConsumer(Long id, Favourite favourite) {
        // retrieve the consumer from the database
        Consumer selectedConsumer = consumerRepository.findById(id).orElseThrow(() -> new ConsumerNotFoundException(id));

        // add the consumer to the favourite: associating relationship
        favourite.setConsumer(selectedConsumer);

        // save the favourite to the database
        return favouriteRepository.save(favourite);
    }



}
