package epic;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Config {
    public java.util.Properties getProperties(String project) throws IOException {
        Properties properties = new java.util.Properties();
        String propertiesFileName = project + ".properties";

        InputStream inputStream = getClass().getClassLoader().getResourceAsStream(propertiesFileName);

        if (inputStream != null) {
            properties.load(inputStream);
        }
        else {
            throw new FileNotFoundException("Property file: " + propertiesFileName + " not found.");
        }

        return properties;
    }
}
