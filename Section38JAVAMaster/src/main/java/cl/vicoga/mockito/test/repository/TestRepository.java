package cl.vicoga.mockito.test.repository;

import cl.vicoga.mockito.test.model.Test;

import java.util.List;

public interface TestRepository {
    Test save(Test test);
    List<Test> findAll();
}
