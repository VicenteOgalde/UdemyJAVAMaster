import java.util.Properties;

public class SystemProperties {

    public static void main(String[] args) {

        String user= System.getProperty("user.name");
        System.out.println(user);
        String home= System.getProperty("user.home");
        System.out.println(home);
        String workSpace= System.getProperty("user.dir");
        System.out.println(workSpace);
        String java= System.getProperty("java.version");
        System.out.println(java);

        Properties properties= System.getProperties();

        properties.list(System.out);

    }
}
