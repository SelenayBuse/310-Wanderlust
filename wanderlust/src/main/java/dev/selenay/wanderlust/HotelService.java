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

    public Optional<Hotels> singleHotel(ObjectId id){
        return hotelRepository.findById(id);
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
