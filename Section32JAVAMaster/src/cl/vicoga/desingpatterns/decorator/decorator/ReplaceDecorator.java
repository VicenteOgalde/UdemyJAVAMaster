package cl.vicoga.desingpatterns.decorator.decorator;

import cl.vicoga.desingpatterns.decorator.Format;

public class ReplaceDecorator extends TextDecorator{
    public ReplaceDecorator(Format text) {
        super(text);
    }

    @Override
    public String format() {

        return text.format().replaceAll(" ","_");
    }
}
