package cl.vicoga.abstractClass.form.validator;

public class NotNull extends Validator{

    protected String message="the field cant be null";





    @Override
    public void setMessage(String message) {
        this.message=message;
    }

    @Override
    public String getMessage() {
        return this.message;
    }

    @Override
    public boolean isValidated(String value) {
        return (value!=null);
    }
}
