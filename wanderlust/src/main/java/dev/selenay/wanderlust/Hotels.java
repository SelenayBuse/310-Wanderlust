package dev.selenay.wanderlust;
import java.util.Calendar;
import java.util.Vector;

import lombok.*;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "hotels")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Hotels {
    @Id
    private ObjectId hotelId;
    private String hotel_name;
    private int hotel_Star;
    private Vector<String> hotel_amenities;
    private String district;
    private String city;
    private int likes;
    private Vector<Comments> comments;

    public Hotels(ObjectId hotelId, String hotel_name, int hotel_Star, Vector<String> hotel_amenities, String district, String city) {
        this.hotelId = hotelId;
        this.hotel_name = hotel_name;
        this.hotel_Star = hotel_Star;
        this.hotel_amenities = new Vector<>(hotel_amenities);
        this.district = district;
        this.city = city;
        this.likes = 0;
        this.comments = new Vector<>();
    }

    public ObjectId getObjectId() {
        return new ObjectId(String.valueOf(hotelId));
    }
    public void incrementLikes(){
        this.likes++;
    }
    public int getLikes(){
        return likes;
    }

    public Vector<Comments> getComments() {
        return comments;
    }
}
