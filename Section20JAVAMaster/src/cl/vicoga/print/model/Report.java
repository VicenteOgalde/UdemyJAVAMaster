package cl.vicoga.print.model;

public class Report extends Sheet{

    private String author;
    private String reviewer;

    public Report(String content) {
        super(content);
    }

    public Report(String content, String author, String reviewer) {
        super(content);
        this.author = author;
        this.reviewer = reviewer;
    }

    @Override
    public String print() {
        return "Report by "+this.author+" review by "+this.reviewer
                +"\n"+this.content;
    }
}
