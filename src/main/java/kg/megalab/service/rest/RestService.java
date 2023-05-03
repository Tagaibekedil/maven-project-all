package kg.megalab.service.rest;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class RestService {

    OkHttpClient client = new OkHttpClient();

    public String run(String url) {
        Request request = new Request.Builder().url(url).build();
        String massage = null;
        try (Response response = client.newCall(request).execute()) {
            //System.out.println(response.code());
            if (response.isSuccessful()) {
                massage = response.body().string();
            }
        } catch (Exception e) {
            massage = e.getMessage();
        }
        return massage;
    }
}
