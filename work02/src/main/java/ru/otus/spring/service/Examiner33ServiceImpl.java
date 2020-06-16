package ru.otus.spring.service;

import lombok.RequiredArgsConstructor;
import ru.otus.spring.dao.QuestionDao;
import ru.otus.spring.domain.Question;

import java.util.List;
import java.util.Scanner;

@RequiredArgsConstructor
public class Examiner33ServiceImpl implements Examiner33Service {

    private final QuestionDao questionDao;
    private final Integer requiredCorrectAnswers;

    private static final String ENTER_NAME = "Enter your lastname and name: ";
    private static final String WELCOME = "%s, welcome to Examiner33!!!";
    private static final String QUESTION = "Question: %s Your answer: ";
    private static final String RESULT = "%s, %s (%d out of %d)";
    private static final String SUCCESS = "test completed successfully!";
    private static final String FAIL = "test failed =(";

    public void start() {
        List<Question> questionList = questionDao.getQuestions();
        Scanner scanner = new Scanner(System.in);
        int correctAnswers = 0;

        //спрашиваем имя, приветствуем
        System.out.print(ENTER_NAME);
        String userName = scanner.nextLine();
        System.out.println(String.format(WELCOME, userName));
        //спрашиваем ответы на вопросы
        for (Question question : questionList){
            System.out.println(String.format(QUESTION, question.getQuestion()));
            String userAnswer = scanner.nextLine();
            if (userAnswer.equalsIgnoreCase(question.getAnswer())) {
                correctAnswers++;
            }
        }
        //сообщаем результат
        System.out.println(String.format(RESULT, userName, (correctAnswers >= requiredCorrectAnswers ? SUCCESS : FAIL), correctAnswers, questionList.size()));
        //через aspectj выведеться затраченное время
    }
}
