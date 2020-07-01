package ru.otus.spring.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.MessageSource;
import ru.otus.spring.config.Examiner33Config;
import ru.otus.spring.dao.QuestionDao;
import ru.otus.spring.domain.Question;

import java.util.Collections;
import java.util.Locale;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
class Examiner33ServiceTest {

    @Mock
    private Examiner33Config examiner33Config;

    @Mock
    private MessageSource messageSource;

    @MockBean
    private ReadWriteService readWriteService;

    @MockBean
    @Qualifier("questionDaoImpl")
    private QuestionDao questionDao;

    @DisplayName("start Examiner33")
    @Test
    void start() {
        when(examiner33Config.getQuestionsRequiredcorrectanswers()).thenReturn(1);
        when(examiner33Config.getLocale()).thenReturn(new Locale("ru", "RU"));
        when(questionDao.getQuestions()).thenReturn(Collections.singletonList(Question.builder().question("questions.question1").answer("questions.answer1").build()));
        when(messageSource.getMessage("questions.question1", null, Locale.getDefault())).thenReturn("2+2=4?");
        when(messageSource.getMessage("questions.answer1", null, Locale.getDefault())).thenReturn("yes");
        when(readWriteService.read("name")).thenReturn("Ivanov Ivan");
        when(readWriteService.read("2+2=4?")).thenReturn("yes");

        Examiner33Service examiner33Service = new Examiner33ServiceImpl(questionDao, readWriteService, messageSource, examiner33Config);
        Boolean examenResult = examiner33Service.start();
        System.out.println(readWriteService.read("name") +" "+ examenResult);
        assertEquals(examenResult, true);
    }
}