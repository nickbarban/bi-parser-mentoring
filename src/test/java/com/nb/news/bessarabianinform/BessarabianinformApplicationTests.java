package com.nb.news.bessarabianinform;

import com.nb.news.bessarabianinform.domain.Article;
import com.nb.news.bessarabianinform.service.NewsParser;
import com.nb.news.bessarabianinform.service.NewsSecondParser;
import org.assertj.core.api.Assertions;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.util.Assert;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
@TestPropertySource(properties = "PORT=8080")
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
        void should_get_news_second() throws IOException {
            final var url = "http://gorod24.info/";
            final var document = Jsoup.connect(url).get();
            final Elements list = document.select("div.cck_module_list");
            final Element firstList = list.first();
            Assert.notNull(list, "");
            final  Elements firstListDivs = firstList.select("li");
            Assert.isTrue(!firstListDivs.isEmpty());
    }

}
