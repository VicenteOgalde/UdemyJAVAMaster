package cl.vicoga.print.model;

import java.util.ArrayList;
import java.util.List;

public class Resume extends Sheet implements Printable{

    private String name;
    private String career;
    private List<String> exp;

    public Resume(String content) {
        super(content);
        this.exp= new ArrayList<String>();
    }

    public Resume(String content, String name, String career) {
        this(content);
        this.name = name;
        this.career = career;

    }
    public Resume addExp(String ex){this.exp.add(ex); return this;}

    @Override
    public String print() {
        StringBuilder sb = new StringBuilder("name: ");
        sb.append(this.name).append("\n")
                .append("career: ").append(this.career)
                .append("\n")
                .append(this.content).append("\n")
                .append("Experiences: ");

        this.exp.forEach(e->{
            sb.append("\n")
                    .append("-")
                    .append(e);
        });

        return sb.toString();
    }
}
