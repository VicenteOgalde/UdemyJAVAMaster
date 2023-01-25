package cl.vicoga.mockito.test.service;

import cl.vicoga.mockito.test.repository.QuestionRepository;
import cl.vicoga.mockito.test.repository.TestRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class TestServiceImplTest {
    TestRepository repository;
    TestService service;
    QuestionRepository questionRepository;
    @BeforeEach
    void setUp() {
        repository = mock(TestRepository.class);
        questionRepository=mock(QuestionRepository.class);
        service= new TestServiceImpl(repository,questionRepository);
    }

    @Test
    void findTestByName() {


        List<cl.vicoga.mockito.test.model.Test> tests= Arrays.asList(
                new cl.vicoga.mockito.test.model.Test(1L,"t1"),
                new cl.vicoga.mockito.test.model.Test(2L,"t2"),
                new cl.vicoga.mockito.test.model.Test(3L,"t3"));

        when(repository.findAll()).thenReturn(tests);

        Optional<cl.vicoga.mockito.test.model.Test> test = service.findTestByName("t1");

        assertTrue(test.isPresent());
        assertEquals("t1",test.get().getName());





    }
    @Test
    void findTestByNameEmptyList() {


        List<cl.vicoga.mockito.test.model.Test> tests= Collections.emptyList();

        when(repository.findAll()).thenReturn(tests);

        Optional<cl.vicoga.mockito.test.model.Test> test = service.findTestByName("t1");

        assertTrue(test.isEmpty());






    }
}