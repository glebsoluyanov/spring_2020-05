package ru.otus.spring.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.otus.spring.dao.QuestionDao;
import ru.otus.spring.dao.QuestionDaoImpl;

@Configuration
public class DaoConfig {

    @Bean
    public QuestionDao questionDao(@Value("${questions.file}") String path){ return  new QuestionDaoImpl(path);}

}
