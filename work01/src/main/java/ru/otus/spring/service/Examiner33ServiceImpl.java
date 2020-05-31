package ru.otus.spring.service;

import lombok.RequiredArgsConstructor;
import ru.otus.spring.dao.QuestionDao;
import ru.otus.spring.domain.Question;

import java.io.IOException;
import java.util.List;

@RequiredArgsConstructor
public class Examiner33ServiceImpl implements Examiner33Service {

    private final QuestionDao questionDao;

    public void start() throws IOException {
        List<Question> questionList = questionDao.getQuestions("/questions.csv");
        for (Question question : questionList){
            System.out.println("Question: " + question.getQuestion());
            System.out.println("Answer: " + question.getAnswer());
        }
    }
}
