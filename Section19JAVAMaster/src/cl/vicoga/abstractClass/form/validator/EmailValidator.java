package cl.vicoga.abstractClass.form.validator;

public class EmailValidator extends Validator{

    protected String message="invalid email format";

    private final static String EMAIL_REGEX="^(.+)@(.+)$";

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
        return value.matches(EMAIL_REGEX);
    }
}
