package kg.megalab.config.properties;

import kg.megalab.model.JsonModelApi;
import kg.megalab.service.rest.JsonMapper;
import kg.megalab.service.rest.RestService;
import lombok.Data;
import java.io.IOException;
import java.sql.*;

@Data
public class ConnectionProperties {
    final String DB_URL = "jdbc:postgresql://localhost:5432/post_db";
    final String USER = "postgres";
    final String PASS = "postgres";

    public int count(JsonModelApi jsonModelApi, Selects selects)  {
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
             PreparedStatement statement = conn.prepareStatement(selects.getQUERY1())) {
            for (int i = 0; i < jsonModelApi.getPosts().size(); i++) {
                statement.setInt(1, jsonModelApi.getPosts().get(i).getId());
                statement.setString(2, jsonModelApi.getPosts().get(i).getTitle());
                statement.setString(3, jsonModelApi.getPosts().get(i).getBody());
                statement.setInt(4, jsonModelApi.getPosts().get(i).getUserId());
                statement.setInt(5, jsonModelApi.getPosts().get(i).getReactions());
                int count = statement.executeUpdate();
            }
        } catch (
                SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public int countTag( JsonModelApi jsonModelApi,Selects selects){
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
             PreparedStatement statement = conn.prepareStatement(selects.getQUeRY3())) {
            System.out.println(jsonModelApi);
            for (int i = 0; i < jsonModelApi.getPosts().size(); i++) {
                statement.setString(1, jsonModelApi.getPosts().get(i).getTags().toString());
                statement.setInt(2, jsonModelApi.getPosts().get(i).getId());
                int count = statement.executeUpdate();
            }
        } catch (
                SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

}






