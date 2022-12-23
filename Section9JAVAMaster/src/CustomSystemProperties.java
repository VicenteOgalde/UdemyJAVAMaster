import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class CustomSystemProperties {
    public static void main(String[] args) {

        try {
            FileInputStream input= new FileInputStream("src/config.properties");
            Properties properties= System.getProperties();


            properties.load(input);

            properties.setProperty("keyp","valuep");

            System.setProperties(properties);

            System.getProperties().list(System.out);

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}
