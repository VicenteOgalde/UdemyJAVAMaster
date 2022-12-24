import java.util.Map;

public class TestEnvironmentVariables {

    public static void main(String[] args) {


        Map<String,String> varEnv=System.getenv();
        System.out.println(varEnv);

        String username= System.getenv("USERNAME");
        System.out.println(username);

        //print key and value
        varEnv.forEach((e,t)-> System.out.println(e+" "+t));

    }
}
