package ru.otus.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ApplicationContext;
import ru.otus.spring.config.Examiner33Config;
import ru.otus.spring.service.Examiner33Service;

@SpringBootApplication
@EnableConfigurationProperties(Examiner33Config.class)
public class Main {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(Main.class, args);
		Examiner33Service service = context.getBean(Examiner33Service.class);
		service.start();
	}

}
