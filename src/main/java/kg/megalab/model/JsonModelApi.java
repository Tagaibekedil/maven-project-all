package kg.megalab.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)

public class JsonModelApi {
    private List<Posts>posts;


}
