package week3;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class PropertiesLoader {

    public static Properties getPreperties() {
        Properties properties = new Properties();
        try {
            properties.load(new FileReader("src/main/resources/jdbc.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return properties;
    }
}
