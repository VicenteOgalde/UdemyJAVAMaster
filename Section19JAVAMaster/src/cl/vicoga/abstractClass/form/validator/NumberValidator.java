package cl.vicoga.abstractClass.form.validator;

public class NumberValidator extends Validator{

    protected String message="this field %s need to be a number";

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
        try {
            Integer.parseInt(value);
            return true;

        }catch (NumberFormatException e){
            return false;

        }


    }
}
