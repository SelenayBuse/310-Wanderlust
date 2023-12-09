package dev.selenay.wanderlust;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

// RESTAURANT CONTROLLER WILL HAVE ENDPOINTS FOR
// SHOW ALL RESTAURANTS
// GET HOW MANY LIKES DOES THE RESTAURANTS HAVE
// GET HOW MANY COMMENTS DOES THE RESTAURANTS HAVE
// POST LIKE TO A RESTAURANTS
// POST COMMENT TO A RESTAURANTS

@RestController
@RequestMapping("/api/v1/restaurants")
public class RestaurantController {
    @Autowired
    private RestaurantService restaurantService;
    @GetMapping
    public ResponseEntity<List<Restaurants>> getAllRestaurants(){ // SHOW ALL RESTAURANTS
        return new ResponseEntity<List<Restaurants>>(restaurantService.allRestaurants(), HttpStatus.OK) ;
    }

    @GetMapping("/{id}") // GET SINGLE RESTAURANT BY ID
    public ResponseEntity<Optional<Restaurants>> getSingleRestaurant(@PathVariable ObjectId id){
        return new ResponseEntity<Optional<Restaurants>>(restaurantService.singleRestaurant(id), HttpStatus.OK);
    }

    @GetMapping("/{restId}/likes-count")
    public ResponseEntity<Integer> getRestaurantLikes(@PathVariable ObjectId restId) {
        int likesCount = restaurantService.getLikesCount(restId);
        return new ResponseEntity<>(likesCount, HttpStatus.OK);
    }

    @PostMapping("/{restId}/like")
    public ResponseEntity<String> likeRestaurant(@PathVariable ObjectId restId){
        boolean liked = restaurantService.likeRestaurant(restId);

        if(liked){
            return new ResponseEntity<>("Restaurant liked successfully", HttpStatus.OK);
        }

        else{
            return new ResponseEntity<>("Restaurant not found", HttpStatus.NOT_FOUND);
        }
    }

}
