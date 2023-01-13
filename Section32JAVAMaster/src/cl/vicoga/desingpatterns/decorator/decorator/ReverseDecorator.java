package cl.vicoga.desingpatterns.decorator.decorator;

import cl.vicoga.desingpatterns.decorator.Format;

public class ReverseDecorator extends TextDecorator{
    public ReverseDecorator(Format text) {
        super(text);
    }

    @Override
    public String format() {
        StringBuilder sb = new StringBuilder(text.format());
        return sb.reverse().toString();
    }
}
