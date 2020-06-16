package ru.otus.spring.dao;

import lombok.RequiredArgsConstructor;

import ru.otus.spring.domain.Question;
import ru.otus.spring.utils.CSVReader;

import java.util.List;

@RequiredArgsConstructor
public class QuestionDaoImpl implements QuestionDao {

    private final String path;

    public List<Question> getQuestions() {
        List<Question> questionList = CSVReader.getQuestionsFromFile(path);
        return questionList;
    }
}
