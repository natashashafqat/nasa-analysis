package epic.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import epic.Config;
import epic.entities.Epic;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Properties;

public class ApiFetcher {
    Config config = new Config();
    public Epic[] fetchData() throws IOException {
        Epic[] epicData = null;
        URL url = buildNasaUrl();

        try {
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestProperty("accept", "application/json");

            InputStream responseStream = connection.getInputStream();
            ObjectMapper mapper = new ObjectMapper();
            epicData = mapper.readValue(responseStream, Epic[].class);
        }
        catch (Exception e) {
            System.out.println("Error whilst fetching: " + e);
        }

        return epicData;
    }

    public URL buildNasaUrl() throws IOException {
        Properties properties = config.getProperties();

        String apiUrl = properties.getProperty("API_URL");
        String apiKey = properties.getProperty("API_KEY");
        URL url = new URL(apiUrl + apiKey);

        return url;
    }

}
