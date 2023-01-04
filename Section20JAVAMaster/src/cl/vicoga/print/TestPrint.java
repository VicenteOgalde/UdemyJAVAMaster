package cl.vicoga.print;

import cl.vicoga.print.model.*;

public class TestPrint {
    public static void main(String[] args) {
        Resume resume= new Resume("bla bla bla","Tex","developer");
        resume.addExp("Java")
       .addExp("C#")
        .addExp("JS")
        .addExp("Spring");

        Report report = new Report("zzzzzz","DeYo","DeMi");

        print(report);
        print(resume);


        Book book = new Book("Tex","TexasChain", Genre.HORROR);
        book.addPage(new Page(".....p1...")).addPage(new Page("....p2...."))
                .addPage(new Page("....p3...."));
        print(book);


    }

    public static void print(Printable printable){
        System.out.println(printable.print());
    }
}
