package kg.megalab.service.rest;
import java.io.IOException;
import com.fasterxml.jackson.databind.ObjectMapper;
import kg.megalab.model.JsonModelApi;
import lombok.Data;

@Data
public class JsonMapper {
    ObjectMapper objectMapper = new ObjectMapper();

    public JsonModelApi getModel(String json) throws IOException {
        return (objectMapper.readValue(json, JsonModelApi.class));
    }
}
