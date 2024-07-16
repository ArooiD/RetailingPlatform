package ru.mirea.storage;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class StorageApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(StorageApplication.class, args);
    }

}
