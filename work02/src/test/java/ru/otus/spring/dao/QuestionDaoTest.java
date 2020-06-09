package ru.otus.spring.dao;

import org.junit.Test;
import ru.otus.spring.domain.Question;

import java.io.IOException;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;

public class QuestionDaoTest {

    @Test
    public void getQuestionsTest() throws IOException {
        QuestionDao questionDao = new QuestionDaoImpl("/questions.csv");
        List<Question> questions = questionDao.getQuestions();
        assertThat(questions).isNotNull().isNotEmpty();
    }
}