package cl.vicoga.desingpatterns.decorator;

import cl.vicoga.desingpatterns.decorator.decorator.ReplaceDecorator;
import cl.vicoga.desingpatterns.decorator.decorator.ReverseDecorator;
import cl.vicoga.desingpatterns.decorator.decorator.TextDecorator;
import cl.vicoga.desingpatterns.decorator.decorator.UpperCaseText;

public class TestDecorator {
    public static void main(String[] args) {

        Format text = new Text("hello guys");

        TextDecorator textReplace = new ReplaceDecorator(text);
        TextDecorator textReverse = new ReverseDecorator(text);
        TextDecorator textUpper = new UpperCaseText(text);
        System.out.println("textReplace.format() = " + textReplace.format());
        System.out.println("textUpper.format() = " + textUpper.format());
        System.out.println("textReverse.format() = " + textReverse.format());

    }
}
