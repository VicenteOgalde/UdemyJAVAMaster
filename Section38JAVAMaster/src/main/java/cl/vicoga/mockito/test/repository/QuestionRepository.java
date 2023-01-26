package cl.vicoga.mockito.test.repository;

import java.util.List;

public interface QuestionRepository {

    void saveSomeQuestions(List<String> q);
    List<String> findQuestionByTestId(Long id);

}
