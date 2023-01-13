package cl.vicoga.desingpatterns.composite.test;

import cl.vicoga.desingpatterns.composite.Directory;
import cl.vicoga.desingpatterns.composite.File;

public class TestComposite {
    public static void main(String[] args) {
        Directory doc = new Directory("documents");

        Directory java = new Directory("java");

        java.addComponent(new File("composite.pdf"))
                .addComponent(new File("decorator.docx"))
                .addComponent(new File("factory.xml"))
                .addComponent(new File("observer.doc"));
        Directory apiStream = new Directory("apiStream");

        apiStream.addComponent(new File("map.txt"))
                .addComponent(new File("foreach.txt"));

        java.addComponent(apiStream);

        doc.addComponent(java)
                .addComponent(new File("readme.txt"));

        System.out.println(doc.show(0));

    }
}
