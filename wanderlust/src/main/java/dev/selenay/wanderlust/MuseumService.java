package dev.selenay.wanderlust;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MuseumService {
    @Autowired
    private MuseumRepository museumRepository;
    public List<Museums> allMuseums(){
        return museumRepository.findAll();
    }

    public Optional<Museums> singleMuseum(ObjectId id){
        return museumRepository.findById(id);
    }

    public Optional<Museums> getMuseumById(ObjectId id){
        return museumRepository.findById(id);
    }

    public int getLikesCount(ObjectId musId) {
        return getMuseumById(musId)
                .map(Museums::getLikes)  // Map to the number of likes if the hotel is present
                .orElse(0);             // If the hotel is not present, return 0
    }

    public boolean likeMuseum(ObjectId musId) {
        Optional<Museums> optionalMuseum = museumRepository.findById(musId);

        if (optionalMuseum.isPresent()) {
            Museums museum = optionalMuseum.get();
            museum.incrementLikes(); // Assuming you have a method to increment likes in your Hotels class
            museumRepository.save(museum);
            return true;
        } else {
            return false;
        }
    }

}
