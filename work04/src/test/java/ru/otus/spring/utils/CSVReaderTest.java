package ru.otus.spring.utils;

import org.assertj.core.data.Index;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.otus.spring.domain.Question;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class CSVReaderTest {

    @Test
    @DisplayName("Чтение csv файла")
    void getQuestionsFromFile() {
        List<Question> questionList = CSVReader.getQuestionsFromFile("/questions.csv");
        assertThat(questionList)
                .hasSize(2)
                .contains(Question.builder().question("questions.question1").answer("questions.answer1").build(), Index.atIndex(0))
                .contains(Question.builder().question("questions.question2").answer("questions.answer2").build(), Index.atIndex(1));
    }
}