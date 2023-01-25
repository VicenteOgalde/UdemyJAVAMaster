package cl.vicoga.mockito.test.service;

import cl.vicoga.mockito.test.repository.TestRepository;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class TestServiceImplTest {

    @Test
    void findTestByName() {
        TestRepository repository = mock(TestRepository.class);
        TestService service= new TestServiceImpl(repository);

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
        TestRepository repository = mock(TestRepository.class);
        TestService service= new TestServiceImpl(repository);

        List<cl.vicoga.mockito.test.model.Test> tests= Collections.emptyList();

        when(repository.findAll()).thenReturn(tests);

        Optional<cl.vicoga.mockito.test.model.Test> test = service.findTestByName("t1");

        assertTrue(test.isEmpty());
        assertEquals("t1",test.get().getName());





    }
}