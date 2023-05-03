package kg.megalab.config.properties;
import kg.megalab.model.JsonModelApi;
import kg.megalab.model.Posts;
import lombok.Data;

@Data
public class Selects {
    private Posts posts;
    private JsonModelApi jsonModelApi;
    
    private final String QUERY1="INSERT INTO post(id,title,body,user_id,reactions ) VALUES (?,?, ?, ?, ?)";
    private final String QUERY2="select title,body,created_at from post";
    private final String QUeRY3="INSERT INTO tag(name,user_id ) VALUES (?,?)";
}
