package dev.selenay.wanderlust;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.Vector;

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

    public Vector<Comments> getCommentsForMuseum(ObjectId musId) {

        Optional<Museums> optionalMuseum = museumRepository.findById(musId);

        if (optionalMuseum.isPresent()) {
            Museums museum = optionalMuseum.get();
            return new Vector<>(museum.getComments());
        } else {
            return new Vector<>();
        }
    }

    public void addCommentToMuseum(ObjectId musId, Comments comment) throws Exception {
        if (comment == null || comment.getCommentText().isBlank()) {
            throw new IllegalArgumentException("Comment cannot be null or empty.");
        }
        Optional<Museums> optionalMuseum = museumRepository.findById(musId);

        if (optionalMuseum.isPresent()) {
            Museums museum = optionalMuseum.get();
            comment.setCommentId(new ObjectId());
            comment.setTimestamp(LocalDateTime.now());
            museum.getComments().add(comment);
            museumRepository.save(museum);
        } else {
            throw new Exception("The museum you have been commenting on could not be found.");
        }
    }

}
