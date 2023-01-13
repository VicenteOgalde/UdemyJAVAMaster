package cl.vicoga.desingpatterns.decorator;

public class Text implements Format{

    private String text;

    public Text(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String format() {
        return getText();
    }
}
