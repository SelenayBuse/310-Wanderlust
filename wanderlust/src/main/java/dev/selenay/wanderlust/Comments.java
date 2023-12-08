package dev.selenay.wanderlust;
import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;


@Data
public class Comments {
    @Id
    private ObjectId commentId;
    private String author;
    private String text;

    public Comments(ObjectId commentId, String author, String text) {
        this.commentId = commentId;
        this.author = author;
        this.text = text;
    }

}
