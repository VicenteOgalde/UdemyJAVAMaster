package cl.vicoga.mockito.test.service;

import cl.vicoga.mockito.test.model.Test;

public interface TestService {
    Test findTestByName(String name);

}
