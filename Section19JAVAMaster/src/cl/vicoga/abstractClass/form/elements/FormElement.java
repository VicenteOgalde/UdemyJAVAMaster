package cl.vicoga.abstractClass.form.elements;

import cl.vicoga.abstractClass.form.validator.Validator;

import java.util.ArrayList;
import java.util.List;

abstract public class FormElement {

    protected String name;
    protected String value;

    private List<Validator> validators;
    private List<String> errors;
    public FormElement() {
        this.validators= new ArrayList<>();
        this.errors= new ArrayList<>();
    }

    public FormElement(String name) {
        this();
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setValue(String value) {
        this.value = value;
    }
    public FormElement addValidate(Validator validator){
        this.validators.add(validator);
        return this;
    }

    public List<String> getErrors() {
        return errors;
    }

    public boolean isValidated(){
        this.validators.forEach(v->{
            if(!v.isValidated(this.value)){
                this.errors.add(v.getMessage());
            }
        });
        return this.errors.isEmpty();
    }
    public abstract String drawHtml();
}
