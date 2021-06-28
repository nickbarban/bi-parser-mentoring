package com.nb.news.bessarabianinform;

import com.nb.news.bessarabianinform.service.NewsParser;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class BessarabianinformApplicationTests {

    @Autowired
    private NewsParser sut;

    @Test
    void should_get_news() {
        List<String> articles = sut.getNews();

        Assertions.assertThat(articles).isNotEmpty();
    }
}
