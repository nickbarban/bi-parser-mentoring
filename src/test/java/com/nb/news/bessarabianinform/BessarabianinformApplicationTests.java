package com.nb.news.bessarabianinform;

import com.nb.news.bessarabianinform.domain.Article;
import com.nb.news.bessarabianinform.service.NewsParser;
import com.nb.news.bessarabianinform.service.NewsSecondParser;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import java.util.List;

@SpringBootTest
@TestPropertySource(properties = "PORT=880") //880
class BessarabianinformApplicationTests {

    @Autowired
    private NewsParser sut;

 @Autowired
    private NewsSecondParser suts;



    @Test
    void should_get_news() {
        List<Article> articles = sut.getNews();

        Assertions.assertThat(articles).isNotEmpty().doesNotContainNull().allMatch(article -> {
            Assertions.assertThat(article).hasNoNullFieldsOrProperties();
            return true;
        });
    }

    @Test
    void should_get_news_second() {
        List<Article> articles = suts.getNews2();

        org.assertj.core.api.Assertions.assertThat(articles).isNotEmpty().doesNotContainNull().allMatch(article -> {
            Assertions.assertThat(article).hasNoNullFieldsOrProperties();
            return true;
        });
    }

}
