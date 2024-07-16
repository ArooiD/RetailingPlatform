package ru.mirea.showcase;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class ShowCaseApplication extends SpringBootServletInitializer {
	public static void main(String[] args) {
		SpringApplication.run(ShowCaseApplication.class, args);
	}

}
