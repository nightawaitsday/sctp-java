package sg.edu.ntu.fnbapi.service;

import java.util.ArrayList;

import sg.edu.ntu.fnbapi.entity.Consumer;
import sg.edu.ntu.fnbapi.entity.Favourite;

public interface ConsumerService {
    ArrayList<Consumer> searchCustomers(String firstName);
    Consumer createCustomer(Consumer consumer);
    Consumer getCustomer(Long id);
    ArrayList<Consumer> getAllCustomers();
    Consumer updateCustomer(Long id, Consumer consumer);
    void deleteCustomer(Long id);
    Favourite addFavouriteToCustomer(Long id, Favourite favourite);
} 
