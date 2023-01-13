package cl.vicoga.desingpatterns.decorator.decorator;

import cl.vicoga.desingpatterns.decorator.Format;

public abstract class TextDecorator implements Format {

    protected Format text;

    public TextDecorator(Format text) {
        this.text = text;
    }
}
