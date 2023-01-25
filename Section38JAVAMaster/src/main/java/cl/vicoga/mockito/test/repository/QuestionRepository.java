package cl.vicoga.mockito.test.repository;

import java.util.List;

public interface QuestionRepository {
    List<String> findQuestionByTestId(Long id);

}
