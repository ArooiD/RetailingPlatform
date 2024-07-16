package ru.mirea.logger;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class LoggerApplication extends SpringBootServletInitializer {
private String j;
    public static void main(String[] args) {
        SpringApplication.run(LoggerApplication.class, args);
    }

}
