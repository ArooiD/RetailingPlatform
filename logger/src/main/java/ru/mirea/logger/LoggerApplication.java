package ru.mirea.logger;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan(basePackages = "ru.mirea.sdk")
@EnableJpaRepositories(basePackages = "ru.mirea.sdk")
public class LoggerApplication extends SpringBootServletInitializer {
    private String j;

    public static void main(String[] args) {
        SpringApplication.run(LoggerApplication.class, args);
    }

}
