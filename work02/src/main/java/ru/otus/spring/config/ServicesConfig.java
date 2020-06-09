package ru.otus.spring.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.otus.spring.dao.QuestionDao;
import ru.otus.spring.service.Examiner33Service;
import ru.otus.spring.service.Examiner33ServiceImpl;

@Configuration
public class ServicesConfig {

    @Bean
    public Examiner33Service examiner33Service(QuestionDao dao, @Value("${questions.requiredcorrectanswers}") Integer requiredCorrectAnswers) { return new Examiner33ServiceImpl(dao, requiredCorrectAnswers); }

}
