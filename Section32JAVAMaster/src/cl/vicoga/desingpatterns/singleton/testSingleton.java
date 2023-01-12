package cl.vicoga.desingpatterns.singleton;

public class testSingleton {
    public static void main(String[] args) {


        for (int i = 0; i < 10; i++) {
            ConnectionBDSingleton con =ConnectionBDSingleton.getInstance();
            System.out.println("con = " + con);
        }
        ConnectionBDSingleton con =ConnectionBDSingleton.getInstance();
        ConnectionBDSingleton con2 =ConnectionBDSingleton.getInstance();

        if (con.equals(con2)) {
            System.out.println("the same");
        }

    }
}
