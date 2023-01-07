package cl.vicoga.list;

import cl.vicoga.set.model.Student;

import java.util.*;

public class TestListComparableComparator {
    public static void main(String[] args) {


        List<Student> t= new ArrayList<>();
        t.add(new Student("tex",5));
        t.add(new Student("tex",5));
        t.add(new Student("tix",4));
        t.add(new Student("tox",7));
        t.add(new Student("tax",3));
        t.add(new Student("tax",3));

        System.out.println(t);

        //t.sort(Student::compareTo);
        t.sort(Comparator.comparing(Student::getGrade));
        //Collections.sort(t,(a,b)->a.getGrade().compareTo(b.getGrade()));
        t.forEach(System.out::println);





    }
}
