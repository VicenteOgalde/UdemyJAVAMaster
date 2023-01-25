package cl.vicoga.mockito.test.service;

import cl.vicoga.mockito.test.model.Test;
import cl.vicoga.mockito.test.repository.TestRepository;

import java.util.Optional;

public class TestServiceImpl implements TestService{

    private TestRepository repository;

    public TestServiceImpl(TestRepository repository) {
        this.repository = repository;
    }

    @Override
    public Optional<Test> findTestByName(String name) {
        return repository.findAll().stream().filter(f->f.getName().equalsIgnoreCase(name))
                .findFirst();
    }
}
