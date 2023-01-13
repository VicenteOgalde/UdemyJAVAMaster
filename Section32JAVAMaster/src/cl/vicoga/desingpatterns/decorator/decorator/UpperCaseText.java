package cl.vicoga.desingpatterns.decorator.decorator;

import cl.vicoga.desingpatterns.decorator.Format;

public class UpperCaseText extends TextDecorator{


    public UpperCaseText(Format text) {
        super(text);
    }

    @Override
    public String format() {
        return text.format().toUpperCase();
    }
}
