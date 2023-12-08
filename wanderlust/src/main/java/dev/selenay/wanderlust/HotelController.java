package dev.selenay.wanderlust;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

// HOTEL CONTROLLER WILL HAVE ENDPOINTS FOR
    // SHOW ALL HOTELS
    // SHOW HOTEL BY THE ATTRIBUTE
    // GET HOW MANY LIKES DOES THE HOTEL HAVE
    // GET HOW MANY COMMENTS DOES THE HOTEL HAVE
    // POST LIKE TO A HOTEL
    // POST COMMENT TO A HOTEL

@RestController
@RequestMapping("/api/v1/hotels")
public class HotelController {
    @Autowired
    private HotelService hotelService;
    @GetMapping
    public ResponseEntity<List<Hotels>> getAllHotels(){ // SHOW ALL HOTELS
        return new ResponseEntity<List<Hotels>>(hotelService.allHotels(), HttpStatus.OK) ;
    }

}
