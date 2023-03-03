package learnpatterns;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertiesService {
    private static PropertiesService propertiesLazyService;
    private final String PATH = "src/Resources/config.properties";
    private Properties properties;
    private PropertiesService() {
        try (FileInputStream fis = new FileInputStream(PATH)) {
            this.properties = new Properties();
            this.properties.load(fis);
        }
        catch (FileNotFoundException e) { System.out.println("File not found"); }
        catch (IOException e) { System.out.println("Can't read properties from a file"); }
    }

    public static PropertiesService getInstance(){
        if (propertiesLazyService == null) propertiesLazyService = new PropertiesService();
        return propertiesLazyService;
    }

    public Properties getProperties() {
        return properties;
    }
}
