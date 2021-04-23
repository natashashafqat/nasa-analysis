package interfaces;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import epic.Config;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Properties;

public abstract class Fetcher<T> {

    public abstract TypeReference<T> getTypeReference();

    public T fetchData(Config config) throws IOException {
        T data = null;
        URL url = getApiUrl(config);

        try {
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestProperty("accept", "application/json");

            InputStream responseStream = connection.getInputStream();
            ObjectMapper mapper = new ObjectMapper();
            data = mapper.readValue(responseStream, getTypeReference());
        }
        catch (Exception e) {
            System.out.println("Error whilst fetching: " + e);
        }

        return data;
    }

    public abstract String projectName();

    public URL getApiUrl(Config config) throws IOException {
        Properties properties = config.getProperties(projectName());
        String apiUrl = properties.getProperty("API_URL");
        String apiKey = properties.getProperty("API_KEY");
        URL url = new URL(apiUrl + apiKey);

        return url;
    }
}
