package ru.otus.spring;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.otus.spring.service.Examiner33Service;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("/spring-context.xml");

        Examiner33Service service = context.getBean(Examiner33Service.class);
        service.start();

    }
}
