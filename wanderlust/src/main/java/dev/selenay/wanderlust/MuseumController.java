package dev.selenay.wanderlust;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

// MUSEUM CONTROLLER WILL HAVE ENDPOINTS FOR
// SHOW ALL MUSEUMS
// GET HOW MANY LIKES DOES THE MUSEUMS HAVE
// GET HOW MANY COMMENTS DOES THE MUSEUMS HAVE
// POST LIKE TO A MUSEUM
// POST COMMENT TO A MUSEUM

@RestController
@RequestMapping("/api/v1/museums")
public class MuseumController {
    @Autowired
    private MuseumService museumService;
    @GetMapping
    public ResponseEntity<List<Museums>> getAllMuseums(){ // SHOW ALL MUSEUMS
        return new ResponseEntity<List<Museums>>(museumService.allMuseums(), HttpStatus.OK) ;
    }

    @GetMapping("/{id}") // GET SINGLE MUSEUM BY ID
    public ResponseEntity<Optional<Museums>> getSingleMuseum(@PathVariable ObjectId id){
        return new ResponseEntity<Optional<Museums>>(museumService.singleMuseum(id), HttpStatus.OK);
    }

    @GetMapping("/{musId}/likes-count")
    public ResponseEntity<Integer> getMuseumLikes(@PathVariable ObjectId musId) {
        int likesCount = museumService.getLikesCount(musId);
        return new ResponseEntity<>(likesCount, HttpStatus.OK);
    }

    @PostMapping("/{musId}/like")
    public ResponseEntity<String> likeMuseum(@PathVariable ObjectId musId){
        boolean liked = museumService.likeMuseum(musId);

        if(liked){
            return new ResponseEntity<>("Museum liked successfully", HttpStatus.OK);
        }

        else{
            return new ResponseEntity<>("Museum not found", HttpStatus.NOT_FOUND);
        }
    }


}


