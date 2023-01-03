package cl.vicoga.print.model;

abstract public class Sheet {

    protected String content;

    public Sheet(String content) {
        this.content = content;
    }

    abstract public String print();
}
