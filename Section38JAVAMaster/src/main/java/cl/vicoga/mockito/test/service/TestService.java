package cl.vicoga.mockito.test.service;

import cl.vicoga.mockito.test.model.Test;

import java.util.Optional;

public interface TestService {
    Optional<Test> findTestByName(String name);

    Test findTestByNameWithQuestion(String name);

}
