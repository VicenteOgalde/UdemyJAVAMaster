package cl.vicoga.abstractClass.form.elements;

import cl.vicoga.abstractClass.form.elements.select.Option;

import java.util.ArrayList;
import java.util.List;

public class SelectForm extends FormElement{

    private List<Option> options;

    public SelectForm(String name) {
        super(name);
        this.options = new ArrayList<Option>();
    }

    public SelectForm(String name, List<Option> options) {
        super(name);
        this.options = options;
    }
    public SelectForm addOption(Option option){
        this.options.add(option);
        return this;
    }

    @Override
    public String drawHtml() {
        StringBuilder sb = new StringBuilder("<select ");
        sb.append("name='")
                .append(this.name+"'>");

        for (Option o:this.options) {
            sb.append("\n<option value='")
                    .append(o.getValue())
                    .append("'");
            if(o.isSelected()){
                sb.append(" selected");
                this.value=o.getValue();
            }
            sb.append(">").append(o.getName())
                    .append("</option>");
        }
        sb.append("</select>");

        return sb.toString();
    }
}
