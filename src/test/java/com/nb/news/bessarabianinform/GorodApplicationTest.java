package com.nb.news.bessarabianinform;

import com.nb.news.bessarabianinform.domain.Article;
import com.nb.news.bessarabianinform.service.NewsSecondParser;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import java.util.List;

@SpringBootTest
@TestPropertySource(properties = "PORT=8080")
class GorodApplicationTest {

    @Autowired
    private NewsSecondParser sut;


    @Test
    void should_get_news_second() {
        List<Article> articles = sut.getNews2();

        org.assertj.core.api.Assertions.assertThat(articles).isNotEmpty().doesNotContainNull().allMatch(article -> {
            Assertions.assertThat(article).hasNoNullFieldsOrProperties();
            return true;
        });
    }


}
