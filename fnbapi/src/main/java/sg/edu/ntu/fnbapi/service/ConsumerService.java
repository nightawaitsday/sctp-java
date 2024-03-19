package sg.edu.ntu.fnbapi.service;

import java.util.ArrayList;

import sg.edu.ntu.fnbapi.entity.Consumer;
import sg.edu.ntu.fnbapi.entity.Favourite;

public interface ConsumerService {
    // ArrayList<Consumer> searchConsumers(String firstName);
    Consumer createConsumer(Consumer consumer);
    Consumer getConsumer(Long id);
    ArrayList<Consumer> getAllConsumers();
    Consumer updateConsumer(Long id, Consumer consumer);
    void deleteConsumer(Long id);
    Favourite addFavouriteToConsumer(Long id, Favourite favourite);
} 
