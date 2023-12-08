package dev.selenay.wanderlust;
import lombok.*;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Map;
import java.util.Vector;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection="museums")
public class Museums {
    @Id
    private ObjectId mus_Id;
    private String mus_name;
    private String exhibition;
    private String district;
    private String city;
    private int likes;
    private Vector<Comments> comments;


    public Museums(ObjectId mus_Id, String mus_name, String exhibition, String district, String city) {
        this.mus_Id = mus_Id;
        this.mus_name = mus_name;
        this.exhibition = exhibition;
        this.district = district;
        this.city = city;
        this.likes = 0;
        this.comments = new Vector<>();
    }



}
