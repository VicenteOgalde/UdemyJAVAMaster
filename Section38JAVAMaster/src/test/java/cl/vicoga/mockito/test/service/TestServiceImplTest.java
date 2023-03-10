package cl.vicoga.mockito.test.service;

import cl.vicoga.mockito.test.repository.QuestionRepository;
import cl.vicoga.mockito.test.repository.TestRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.*;

import java.util.Collections;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(MockitoExtension.class)
class TestServiceImplTest {
    @Mock
    TestRepository repository;

    @InjectMocks
    TestServiceImpl service;
    @Mock
    QuestionRepository questionRepository;
    @BeforeEach
    void setUp() {

        //MockitoAnnotations.openMocks(this);


//        repository = mock(TestRepository.class);
//        questionRepository=mock(QuestionRepository.class);
//        service= new TestServiceImpl(repository,questionRepository);
    }

    @Test
    void findTestByName() {

        when(repository.findAll()).thenReturn(Data.DATA_TEST);

        Optional<cl.vicoga.mockito.test.model.Test> test = service.findTestByName("t1");

        assertTrue(test.isPresent());
        assertEquals("t1",test.get().getName());





    }
    @Test
    void findTestByNameEmptyList() {
        when(repository.findAll()).thenReturn(Collections.emptyList());

        Optional<cl.vicoga.mockito.test.model.Test> test = service.findTestByName("t1");

        assertTrue(test.isEmpty());






    }

    @Test
    void findTestQuestion() {

        when(repository.findAll()).thenReturn(Data.DATA_TEST);
        when(questionRepository.findQuestionByTestId(anyLong())).thenReturn(Data.DATA_QUESTION);

        cl.vicoga.mockito.test.model.Test test = service.findTestByNameWithQuestion("t2");

        assertEquals(3,test.getQuestions().size());



    }
    @Test
    void findTestQuestionVerify() {

        when(repository.findAll()).thenReturn(Data.DATA_TEST);
        when(questionRepository.findQuestionByTestId(anyLong())).thenReturn(Data.DATA_QUESTION);

        cl.vicoga.mockito.test.model.Test test = service.findTestByNameWithQuestion("t2");

        assertEquals(3,test.getQuestions().size());

        verify(repository).findAll();
        verify(questionRepository).findQuestionByTestId(anyLong());




    }
    @Test
    void findTestQuestionVerifyNotExist() {

        when(repository.findAll()).thenReturn(Collections.emptyList());
        when(questionRepository.findQuestionByTestId(anyLong())).thenReturn(Data.DATA_QUESTION);

        cl.vicoga.mockito.test.model.Test test = service.findTestByNameWithQuestion("t5");

        assertNull(test);

        verify(repository).findAll();
        verify(questionRepository).findQuestionByTestId(anyLong());




    }

    @Test
    void saveTestTest() {
        when(repository.save(any(cl.vicoga.mockito.test.model.Test.class)))
                .thenReturn(Data.TEST);
        cl.vicoga.mockito.test.model.Test t=service.saveTest(Data.TEST);
        assertNotNull(t);
        assertEquals(8L,t.getId());


    }
}