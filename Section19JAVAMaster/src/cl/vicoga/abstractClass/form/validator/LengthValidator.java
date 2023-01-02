package cl.vicoga.abstractClass.form.validator;

public class LengthValidator extends Validator{
    protected String message="this field need a minimum of %d" +
            " and maximum of %d characters";
    private int min;
    private int max=255;

    public LengthValidator() {
    }

    public LengthValidator(int min, int max) {
        this.min = min;
        this.max = max;
    }

    public int getMin() {
        return min;
    }

    public void setMin(int min) {
        this.min = min;
    }

    public int getMax() {
        return max;
    }

    public void setMax(int max) {
        this.max = max;
    }

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
        this.message=String.format(this.message,this.min,this.max);
        if(value==null){
            return true;
        }

        return (value.length()>=this.min && value.length() <=this.max);
    }
}
