package sg.edu.ntu.fnbapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sg.edu.ntu.fnbapi.service.FavouriteService;

@RestController
@RequestMapping("/favourites")
public class FavouriteController {

    private FavouriteService favouriteService;

    @Autowired
    public FavouriteController(FavouriteService favouriteService) {
        this.favouriteService = favouriteService;
    }
}
