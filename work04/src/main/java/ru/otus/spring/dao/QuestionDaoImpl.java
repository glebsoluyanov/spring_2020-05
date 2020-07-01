package ru.otus.spring.dao;

import org.springframework.stereotype.Repository;
import ru.otus.spring.config.Examiner33Config;
import ru.otus.spring.domain.Question;
import ru.otus.spring.utils.CSVReader;

import java.util.List;

@Repository
public class QuestionDaoImpl implements QuestionDao {

    private final String path;

    public QuestionDaoImpl(Examiner33Config examiner33Config) {
        path = examiner33Config.getQuestionsFile();
    }

    public List<Question> getQuestions() {
        List<Question> questionList = CSVReader.getQuestionsFromFile(path);
        return questionList;
    }
}
