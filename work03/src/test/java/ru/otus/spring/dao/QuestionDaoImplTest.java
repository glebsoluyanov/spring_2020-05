package ru.otus.spring.dao;

import org.assertj.core.data.Index;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ru.otus.spring.config.Examiner33Config;
import ru.otus.spring.domain.Question;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class QuestionDaoImplTest {

    @Autowired
    private Examiner33Config examiner33Config;

    @Test
    @DisplayName("Получение вопросов")
    void getQuestions() {
        QuestionDao questionDao = new QuestionDaoImpl(examiner33Config);
        List<Question> questionList = questionDao.getQuestions();
        assertThat(questionList)
                .hasSize(2)
                .contains(Question.builder().question("questions.question1").answer("questions.answer1").build(), Index.atIndex(0))
                .contains(Question.builder().question("questions.question2").answer("questions.answer2").build(), Index.atIndex(1));
    }
}