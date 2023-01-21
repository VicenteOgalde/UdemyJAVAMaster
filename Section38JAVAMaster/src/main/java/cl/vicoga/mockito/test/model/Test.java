package cl.vicoga.mockito.test.model;

import java.util.ArrayList;
import java.util.List;

public class Test {
    private Long id;
    private String name;
    private List<String> questions;

    public Test(Long id, String name) {

        this.id = id;
        this.name = name;
        this.questions = new ArrayList<>();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getQuestions() {
        return questions;
    }

    public void setQuestions(List<String> questions) {
        this.questions = questions;
    }
    public void addQuestion(String q){
        this.questions.add(q);
    }
}
