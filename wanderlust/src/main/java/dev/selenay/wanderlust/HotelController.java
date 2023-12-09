package dev.selenay.wanderlust;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Hotels>> getSingleHotel(@PathVariable ObjectId id){
        return new ResponseEntity<Optional<Hotels>>(hotelService.singleHotel(id), HttpStatus.OK);
    }








}
