package cl.vicoga.desingpatterns.singleton;

public class ConnectionBDSingleton {

    private static ConnectionBDSingleton instance;

    private ConnectionBDSingleton() {
        System.out.println("bd connexion");
    }

    public static ConnectionBDSingleton getInstance() {
        if (instance == null) {
            instance= new ConnectionBDSingleton();
        }

        return instance;
    }
}
