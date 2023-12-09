package dev.selenay.wanderlust;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HotelService {
    @Autowired
    private HotelRepository hotelRepository;
    public List<Hotels> allHotels(){
        return hotelRepository.findAll();
    }

    public Optional<Hotels> getHotelById(ObjectId id){
        return hotelRepository.findById(id);
    }

    public int getLikesCount(ObjectId hotelId) {
        return getHotelById(hotelId)
                .map(Hotels::getLikes)  // Map to the number of likes if the hotel is present
                .orElse(0);             // If the hotel is not present, return 0
    }

    public boolean likeHotel(ObjectId hotelId) {
        Optional<Hotels> optionalHotel = hotelRepository.findById(hotelId);

        if (optionalHotel.isPresent()) {
            Hotels hotel = optionalHotel.get();
            hotel.incrementLikes(); // Assuming you have a method to increment likes in your Hotels class
            hotelRepository.save(hotel);
            return true;
        } else {
            return false;
        }
    }


}
