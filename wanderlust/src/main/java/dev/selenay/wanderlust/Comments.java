package dev.selenay.wanderlust;
import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document(collection = "comments")
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

    public void setCommentId(ObjectId commentId) {
        this.commentId = commentId;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setText(String text){
        this.text = text;
    }

    public String getCommentText(){
        return this.text;
    }
}
