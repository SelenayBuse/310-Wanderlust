package dev.selenay.wanderlust;

import java.util.Vector;

import lombok.*;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection="restaurants")
public class Restaurants {
    @Id
    private ObjectId restId;
    private String restName;
    private String restCuisine;
    private Boolean hasMichelin;
    private String district;
    private String city;
    private int likes;
    private Vector<Comments> comments;

    public Restaurants(ObjectId restId, String restName, String restCuisine, Boolean hasMichelin,
                       String district, String city) {
        this.restId = restId;
        this.restName = restName;
        this.restCuisine = restCuisine;
        this.hasMichelin = hasMichelin;
        this.district = district;
        this.city = city;
        this.likes = 0;
        this.comments = new Vector<>();
    }

    public void incrementLikes(){
        this.likes++;
    }

    public int getLikes(){
        return likes;
    }
}
