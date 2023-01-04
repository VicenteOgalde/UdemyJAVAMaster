package cl.vicoga.print.model;

import java.util.ArrayList;
import java.util.List;

public class Book implements Printable{

    private List<Page> pages;
    private String author;
    private String title;
    private Genre genre;

    public Book() {
        this.pages=new ArrayList<Page>();
    }

    public Book(String author, String title, Genre genre) {
        this();
        this.author = author;
        this.title = title;
        this.genre = genre;
    }
    public Book addPage(Page page){
        this.pages.add(page);
        return this;
    }
    public String print(){
        StringBuilder sb= new StringBuilder("Title: ");
        sb.append(this.title).append("\n")
                .append("Genre: ").append(this.genre).append("\n")
                .append("Author: ").append(this.author).append("\n");

        this.pages.forEach(p->{
            sb.append(p.print()).append("\n");
        });

        return sb.toString();
    }
}
