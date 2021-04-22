package epic.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import epic.entities.Epic;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Properties;

public class ApiFetcher {
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
        Properties properties = new Properties();
        String propertiesFileName = "application.properties";

        InputStream inputStream = getClass().getClassLoader().getResourceAsStream(propertiesFileName);

        if (inputStream != null) {
            properties.load(inputStream);
        }
        else {
            throw new FileNotFoundException("Property file: " + propertiesFileName + " not found.");
        }

        String apiKey = properties.getProperty("API_KEY");
        URL url = new URL("https://api.nasa.gov/EPIC/api/natural?api_key=" + apiKey);

        return url;
    }

}
