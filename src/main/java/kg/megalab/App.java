package kg.megalab;

import com.fasterxml.jackson.annotation.JsonFormat;
import kg.megalab.config.properties.ConnectionProperties;
import kg.megalab.config.properties.RestClientProperties;;
import kg.megalab.config.properties.Selects;
import kg.megalab.model.JsonModelApi;
import kg.megalab.model.JsonModelDb;
import kg.megalab.model.Posts;
import kg.megalab.service.rest.JsonMapper;
import kg.megalab.service.rest.RestService;

import java.io.IOException;
import java.sql.*;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 1. Есть пакеты model, service(dal, rest), config.propeties
 * 2. Создать новую бд и в ней 2 таблицы posts и tags
 * 3. Создать класс с данными для подключения к бд
 * 4. Создать класс с данными для получения данных по апи
 * 5. Создать сервис получения Connection к бд + сервис для работы с бд(сохранение и селект)
 * 6. Создать сервис для получения данных по апи
 * 7.  Данные полученные от апи  сохранить в бд + добавить в таблицу posts колонку created_at которая будет заполнятся автоматически
 * 8. Создать сервис объединяющий сервис получения данных по апи и сохранения их в бд
 * 9. После сохранения вывести на консоль взятые из базы title, body, created_at в формате yyyy.MM.dd hh:mm
 */

public class App {

    static final ConnectionProperties connProp = new ConnectionProperties();

    public static void main(String[] args) throws IOException, SQLException {
        Selects selects=new Selects();
        RestService restService = new RestService();
        JsonMapper jsonMapper = new JsonMapper();
        RestClientProperties clientProperties = new RestClientProperties();
        String response = restService.run(clientProperties.getURL());
        JsonModelApi jsonModelApi = jsonMapper.getModel(response);
        //System.out.println(jsonModelApi);
        ConnectionProperties con=new ConnectionProperties();
        JsonModelDb jsDb=new JsonModelDb();

        //******запрос из базы данных title,body и created_at
        System.out.println(jsDb.getFromDb(selects.getQUERY2()));
        System.out.println("Ваш запрос выполнен!");

        //******заполнение таблицы Post
//        con.count(jsonModelApi,selects);
//        System.out.println("таблица Post заполнена данными!");

        //******заполнение таблицы Tag
//        con.countTag(jsonModelApi,selects);
//        System.out.println("таблица Tag заполнена данными!");
        
    }
}





