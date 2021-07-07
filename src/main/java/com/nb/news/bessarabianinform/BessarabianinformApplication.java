package com.nb.news.bessarabianinform;

import com.nb.news.bessarabianinform.domain.Article;
import com.nb.news.bessarabianinform.service.NewsParser;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@SpringBootApplication
@RestController
public class BessarabianinformApplication {
    private final NewsParser parser;

    public BessarabianinformApplication(NewsParser parser) {
        this.parser = parser;
    }

    public static void main(String[] args) {
        SpringApplication.run(BessarabianinformApplication.class, args);
    }

    @GetMapping
    public List<Article> getNews() {
        return parser.getNews().stream().sorted(Comparator.comparing(Article::getDate)).collect(Collectors.toList());
    }

}
