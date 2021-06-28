package com.nb.news.bessarabianinform;

import com.github.javafaker.Faker;
import com.nb.news.bessarabianinform.service.NewsParser;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@SpringBootApplication
@RestController
public class BessarabianinformApplication {
    private static final Faker FAKER = new Faker();
    private final NewsParser parser;

    public BessarabianinformApplication(NewsParser parser) {
        this.parser = parser;
    }

    public static void main(String[] args) {
        SpringApplication.run(BessarabianinformApplication.class, args);
    }

    @GetMapping
    public List<String> getNews() {
        return parser.getNews();
    }

}
