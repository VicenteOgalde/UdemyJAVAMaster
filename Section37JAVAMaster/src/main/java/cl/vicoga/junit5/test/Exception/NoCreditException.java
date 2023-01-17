package cl.vicoga.junit5.test.Exception;

public class NoCreditException extends RuntimeException{

    public NoCreditException(String message) {
        super(message);
    }
}
