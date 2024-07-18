package ru.mirea.storage;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan(basePackages = "ru.mirea")
@EnableJpaRepositories(basePackages = "ru.mirea")
public class StorageApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(StorageApplication.class, args);
    }

}
