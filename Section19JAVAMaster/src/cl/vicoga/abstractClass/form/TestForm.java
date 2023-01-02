package cl.vicoga.abstractClass.form;

import cl.vicoga.abstractClass.form.elements.FormElement;
import cl.vicoga.abstractClass.form.elements.InputForm;
import cl.vicoga.abstractClass.form.elements.SelectForm;
import cl.vicoga.abstractClass.form.elements.TextAreaForm;
import cl.vicoga.abstractClass.form.elements.select.Option;
import cl.vicoga.abstractClass.form.validator.*;

import java.util.ArrayList;
import java.util.List;

public class TestForm {
    public static void main(String[] args) {

        InputForm username= new InputForm("username");
        username.addValidate(new RequiredToValidate());

        InputForm pass= new InputForm("pass","password");
        pass.addValidate(new RequiredToValidate())
        .addValidate(new LengthValidator(8,25));

        InputForm age= new InputForm("age","number");
        age.addValidate(new NumberValidator());

        InputForm email= new InputForm("meEmail","email");
        email.addValidate(new RequiredToValidate())
                .addValidate(new EmailValidator());


        TextAreaForm exp= new TextAreaForm("exp",5,4);

        SelectForm language= new SelectForm("language");
        language.addValidate(new NotNull());

        Option java = new Option("1","JAVA");

        language.addOption(java).addOption(new Option("2","Python"))
                .addOption(new Option("3","JavaScript"));

        FormElement greet = new FormElement("greet") {
            @Override
            public String drawHtml() {
                return "<input disabled name=\""
                        +this.name+"\" value=\""
                        +this.value+"\">";
            }
        };
    greet.setValue("hello from the disabled field");

        username.setValue("user1");
        pass.setValue("1234567");
        age.setValue("122");
        email.setValue("asd@asd.cl");
        exp.setValue(".....10 years of exp......");

        java.setSelected(true);

        List<FormElement> elements= new ArrayList<>() ;
        elements.add(username);
        elements.add(pass);
        elements.add(age);
        elements.add(email);
        elements.add(exp);
        elements.add(language);
        elements.add(greet);

        elements.forEach(e-> System.out.println(e.drawHtml()));

        elements.forEach(e->{
            if(!e.isValidated()){
                e.getErrors().forEach(err-> System.out.println(e.getName()+": "+ err));
            }
        });





    }
}

