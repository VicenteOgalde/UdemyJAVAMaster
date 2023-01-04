package cl.vicoga.print.model;

public class Page extends Sheet implements Printable{
    public Page(String content) {
        super(content);
    }

    @Override
    public String print() {
        return this.content;
    }
}
