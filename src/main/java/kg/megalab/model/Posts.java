package kg.megalab.model;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class Posts {

    private int id;
    private String title;
    private  String body;
    private  int userId;
    private  int reactions;
    private List<String> tags;
    }


    
