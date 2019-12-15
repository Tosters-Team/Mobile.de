package utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertyConfigurator {

    private static Properties prop;

    static {
        try {
            prop = readPropertiesFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getProperty(String key){
       return prop.getProperty(key);
    }

    private static Properties readPropertiesFile() throws IOException {
        FileInputStream fis = null;
        Properties prop = null;
        try {
            fis = new FileInputStream("src/main/resources/test.properties");
            prop = new Properties();
            prop.load(fis);
        } catch(FileNotFoundException e) {
            e.printStackTrace();
        } catch(IOException e) {
            e.printStackTrace();
        } finally {
            fis.close();
        }
        return prop;
    }

}
