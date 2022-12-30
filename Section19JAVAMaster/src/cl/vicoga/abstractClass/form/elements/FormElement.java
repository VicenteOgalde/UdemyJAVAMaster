package cl.vicoga.abstractClass.form.elements;

abstract public class FormElement {

    protected String name;
    protected String value;

    public FormElement() {
    }

    public FormElement(String name) {
        this();
        this.name = name;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public abstract String drawHtml();
}
