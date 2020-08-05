package ru.otus.spring.service;

import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;
import ru.otus.spring.config.Examiner33Config;
import ru.otus.spring.dao.QuestionDao;
import ru.otus.spring.domain.Question;

import java.util.List;
import java.util.Locale;

@Service
public class Examiner33ServiceImpl implements Examiner33Service {

    private final QuestionDao questionDao;
    private final ReadWriteService readWriteService;
    private final Integer requiredCorrectAnswers;
    private final MessageSource messageSource;
    private final Locale locale;

    public Examiner33ServiceImpl(QuestionDao questionDao, ReadWriteService readWriteService, MessageSource messageSource, Examiner33Config examiner33Config) {
        this.questionDao = questionDao;
        this.readWriteService = readWriteService;
        this.requiredCorrectAnswers = examiner33Config.getQuestionsRequiredcorrectanswers();
        this.messageSource = messageSource;
        this.locale = examiner33Config.getLocale();
    }

    public Boolean start() {
        List<Question> questionList = questionDao.getQuestions();
        int correctAnswers = 0;

        //спрашиваем имя, приветствуем
        readWriteService.write(messageSource.getMessage("message.enter_name", null, locale));
        String userName = readWriteService.read("name");
        readWriteService.writeln(messageSource.getMessage("message.welcome", new Object[]{userName}, locale));
        //спрашиваем ответы на вопросы
        for (Question question : questionList){
            String questiontext = messageSource.getMessage(question.getQuestion(), null, locale);
            String answertext = messageSource.getMessage(question.getAnswer(), null, locale);
            readWriteService.writeln(messageSource.getMessage("message.question", new Object[]{questiontext}, locale));
            String userAnswer = readWriteService.read(questiontext);
            if (userAnswer.equalsIgnoreCase(answertext)) {
                correctAnswers++;
            }
        }
        //сообщаем результат
        readWriteService.writeln(messageSource.getMessage("message.result", new Object[]{
            userName,
            messageSource.getMessage(correctAnswers >= requiredCorrectAnswers ? "message.success" : "message.fail", null, locale),
            correctAnswers,
            questionList.size()
        }, locale));

        return correctAnswers >= requiredCorrectAnswers;
    }
}
