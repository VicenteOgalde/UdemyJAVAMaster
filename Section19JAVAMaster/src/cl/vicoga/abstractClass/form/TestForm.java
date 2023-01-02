package cl.vicoga.abstractClass.form;

import cl.vicoga.abstractClass.form.elements.FormElement;
import cl.vicoga.abstractClass.form.elements.InputForm;
import cl.vicoga.abstractClass.form.elements.SelectForm;
import cl.vicoga.abstractClass.form.elements.TextAreaForm;
import cl.vicoga.abstractClass.form.elements.select.Option;

import java.util.ArrayList;
import java.util.List;

public class TestForm {
    public static void main(String[] args) {

        InputForm username= new InputForm("username");
        InputForm pass= new InputForm("pass","password");
        InputForm age= new InputForm("age","number");
        InputForm email= new InputForm("a@a.a","email");

        TextAreaForm exp= new TextAreaForm("exp",5,4);

        SelectForm language= new SelectForm("language");

        Option java = new Option("1","JAVA");

        language.addOption(java).addOption(new Option("2","Python"))
                .addOption(new Option("3","JavaScript"));

        username.setValue("user1");
        pass.setValue("123");
        age.setValue("12");
        exp.setValue(".....10 years of exp......");

        java.setSelected(true);

        List<FormElement> elements= new ArrayList<>() ;
        elements.add(username);
        elements.add(pass);
        elements.add(age);
        elements.add(email);
        elements.add(exp);
        elements.add(language);

        elements.forEach(e-> System.out.println(e.drawHtml()));





    }
}

