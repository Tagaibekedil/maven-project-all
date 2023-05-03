package kg.megalab.model;

import kg.megalab.config.properties.ConnectionProperties;
import kg.megalab.service.dal.entity.EntityPosts;
import lombok.Data;

import java.sql.*;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Data

public class JsonModelDb {


    public List<String> getFromDb(String selects) throws SQLException {
        ConnectionProperties conn=new ConnectionProperties();
        DateTimeFormatter dateTimeFormatter=DateTimeFormatter.ofPattern("yyyy-MM-dd hh-mm");
        try (Connection connect = DriverManager.getConnection(conn.getDB_URL(), conn.getUSER(), conn.getPASS());
             Statement statement = connect.createStatement();
             ResultSet rs = statement.executeQuery(selects)) {
            List<String> list = new ArrayList<>();
            while (rs.next()) {
                Timestamp tsp=rs.getTimestamp("created_at");
                EntityPosts entry=new EntityPosts();
                entry.setTitle(rs.getString("title"));
                entry.setBody(rs.getString("body"));
                entry.setCreated_at(tsp.toLocalDateTime().format(dateTimeFormatter));
                list.add("TITLE:"+entry.getTitle()+" ,BODY:"+entry.getBody()+" ,CREATED_AT:"+entry.getCreated_at());
            }return list;

        }
    }
}