package ru.otus.spring;

import org.springframework.context.annotation.*;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.otus.spring.service.Examiner33Service;

import java.io.IOException;

@EnableAspectJAutoProxy
@Configuration
@ComponentScan
@PropertySource("classpath:application.properties")
public class Main {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(Main.class);

        Examiner33Service service = context.getBean(Examiner33Service.class);
        service.start();

    }
}
