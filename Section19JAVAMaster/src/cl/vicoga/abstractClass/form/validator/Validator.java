package cl.vicoga.abstractClass.form.validator;

abstract public class Validator {

    protected String message;

    abstract public void setMessage(String message);
    abstract public String getMessage();

    abstract public boolean isValidated(String value);

}
