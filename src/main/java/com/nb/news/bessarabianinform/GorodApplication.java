package com.nb.news.bessarabianinform;

import com.nb.news.bessarabianinform.domain.Article;
import com.nb.news.bessarabianinform.service.NewsSecondParser;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;


@SpringBootApplication
@RestController
public class GorodApplication {
    private final NewsSecondParser parser;

    public GorodApplication(NewsSecondParser parser) {
        this.parser = parser;
    }

    @GetMapping                            // !!!
    public List<Article> getNews2(){
        return parser.getNews2().stream().sorted(Comparator.comparing(Article::getDate)).collect(Collectors.toList());  //
    }
}
