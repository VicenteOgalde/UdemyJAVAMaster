package cl.vicoga.abstractClass.form.validator;

public class RequiredToValidate extends Validator{
    protected String message="the field %s is required";

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
        return (value != null && value.length()>0);
    }
}
