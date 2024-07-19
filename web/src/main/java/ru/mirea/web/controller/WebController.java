package ru.mirea.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.mirea.web.service.WebService;

@RestController
public class WebController {
    private final WebService webService;

    @Autowired
    public WebController(WebService webService) {
        this.webService = webService;
    }

    @GetMapping("test")
    public String test() {
        return "HelloWorld!";
    }

    @GetMapping("fabric")
    public String fabric() {
        return webService.testGetRequest();
    }

    @GetMapping("plan")
    public Object plan(@RequestParam(name = "row") int row, @RequestParam(name = "col") int col) {
        return null;
    }
}
