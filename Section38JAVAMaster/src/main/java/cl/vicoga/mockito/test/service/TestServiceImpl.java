package cl.vicoga.mockito.test.service;

import cl.vicoga.mockito.test.model.Test;
import cl.vicoga.mockito.test.repository.QuestionRepository;
import cl.vicoga.mockito.test.repository.TestRepository;

import java.util.Optional;

public class TestServiceImpl implements TestService{

    private TestRepository repository;
    private QuestionRepository questionRepository;

    public TestServiceImpl(TestRepository repository, QuestionRepository questionRepository) {
        this.repository = repository;
        this.questionRepository=questionRepository;
    }

    @Override
    public Optional<Test> findTestByName(String name) {
        return repository.findAll().stream().filter(f->f.getName().equalsIgnoreCase(name))
                .findFirst();
    }

    @Override
    public Test saveTest(Test test) {
        if(!test.getQuestions().isEmpty()){
            questionRepository.saveSomeQuestions(test.getQuestions());
        }
        return repository.save(test);
    }

    @Override
    public Test findTestByNameWithQuestion(String name) {
        Optional<Test> test = findTestByName(name);
        if(test.isPresent()){
            test.get().setQuestions(questionRepository.findQuestionByTestId(test.get().getId()));
        }
        return test.orElseThrow();
    }
}
