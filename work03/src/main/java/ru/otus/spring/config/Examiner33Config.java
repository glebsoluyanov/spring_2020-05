package ru.otus.spring.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import java.util.Locale;

@Component
@ConfigurationProperties("examiner33")
@Getter
@Setter
public class Examiner33Config {
    private String questionsFile;
    private Integer questionsRequiredcorrectanswers;
    private Locale locale;

}
