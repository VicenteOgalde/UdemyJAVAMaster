package cl.vicoga.abstractClass.form.elements.select;

public class Option {

    private String value;
    private String name;
    private boolean selected;

    public Option() {
    }

    public Option(String value, String name, boolean selected) {
        this.value = value;
        this.name = name;
        this.selected = selected;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }
}
