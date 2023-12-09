package dev.selenay.wanderlust;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RestaurantService {
    @Autowired
    private RestaurantRepository restaurantRepository;
    public List<Restaurants> allRestaurants(){
        return restaurantRepository.findAll();
    }

    public Optional<Restaurants> singleRestaurant(ObjectId id){
        return restaurantRepository.findById(id);
    }

    public Optional<Restaurants> getRestaurantById(ObjectId id){
        return restaurantRepository.findById(id);
    }

    public int getLikesCount(ObjectId restId) {

        return getRestaurantById(restId)
                .map(Restaurants::getLikes)  // Map to the number of likes if the hotel is present
                .orElse(0);             // If the hotel is not present, return 0
    }

    public boolean likeRestaurant(ObjectId restId) {
        Optional<Restaurants> optionalRestaurant = restaurantRepository.findById(restId);

        if (optionalRestaurant.isPresent()) {
            Restaurants restaurant = optionalRestaurant.get();
            restaurant.incrementLikes();
            restaurantRepository.save(restaurant);
            return true;
        } else {
            return false;
        }
    }
}