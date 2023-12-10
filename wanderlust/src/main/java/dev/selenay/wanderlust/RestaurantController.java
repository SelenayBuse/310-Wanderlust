package dev.selenay.wanderlust;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.Vector;

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

    @GetMapping("/{restId}/get-comments")
    public ResponseEntity<Vector<Comments>> getCommentsForRestaurant(@PathVariable ObjectId restId) {
        try {
            Vector<Comments> comments = restaurantService.getCommentsForRestaurant(restId);
            return new ResponseEntity<>(comments, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/{restId}/post-comments")
    public ResponseEntity<String> addCommentToRestaurant(@PathVariable("restId") ObjectId restId, @RequestBody Comments comment) {
        if (comment == null || comment.getCommentText().isBlank()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Comment text cannot be null or empty.");
        }
        try {
            restaurantService.addCommentToRestaurant(restId, comment);
            return ResponseEntity.ok().body("Comment added successfully");

        } catch (Exception e) {
            System.out.println("Exception occurred: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Failed to add comment: " + e.getMessage());
        }
    }

}
