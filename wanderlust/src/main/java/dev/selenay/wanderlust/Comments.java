package dev.selenay.wanderlust;
import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;


@Data
public class Comments {
    @Id
    private ObjectId commentId;
    private String author;
    private String text;
    private LocalDateTime timestamp;

    public Comments(ObjectId commentId, String author, String text, LocalDateTime timestamp) {
        this.commentId = commentId;
        this.author = author;
        this.text = text;
        this.timestamp = timestamp;
    }

}
