package com.nb.news.bessarabianinform;

import com.nb.news.bessarabianinform.domain.Article;
import com.nb.news.bessarabianinform.service.NewsParser;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class BessarabianinformApplicationTests {

    @Autowired
    private NewsParser sut;

    @Test
    void should_get_news() {
        List<Article> articles = sut.getNews();

        Assertions.assertThat(articles).isNotEmpty().doesNotContainNull().allMatch(article -> {
            Assertions.assertThat(article).hasNoNullFieldsOrProperties();
            return true;
        });
    }
}
