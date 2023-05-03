package kg.megalab.service.dal.entity;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

@Data

public class EntityPosts {
    private int id;
    private String title;
    private  String body;
    private  int userId;
    private  int reaction;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy.MM.dd hh:mm")
    private String created_at;
}
