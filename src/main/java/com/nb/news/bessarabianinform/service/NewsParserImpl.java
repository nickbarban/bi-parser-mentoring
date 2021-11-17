package com.nb.news.bessarabianinform.service;

import com.nb.news.bessarabianinform.domain.Article;
import lombok.extern.slf4j.Slf4j;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Implementation for {@link NewsParser}.
 *
 * @author Nick Barban.
 */
@Service
@Slf4j
public class NewsParserImpl implements NewsParser {

    @Override
    public List<Article> getNews() {
        final var url = "https://bessarabiainform.com";
        final List<Article> articles = new ArrayList<>();
        log.info("Parse {}", url);

        try {
            final var document = Jsoup.connect(url).get();
            final Elements lenta = document.select("div.lenta_holder");
            final Element firstLenta = lenta.first();
            final Elements firstLentDivs = firstLenta.select("div");

            for (Element e : firstLentDivs) {
                if (e.select("dfn") != null && e.select("dfn").first() != null) {
                    final Article article = new Article();
                    article.setLink(e.select("a").first().attr("href"));
                    article.setTitle(e.select("a").first().text());
                    final String date = e.select("span.fa").first().text();

                    if (date.equalsIgnoreCase("сегодня")) {
                        article.setDate(LocalDateTime.of(LocalDate.now(), LocalTime.parse(e.select("dfn").first().text())));
                    } else if (date.equalsIgnoreCase("вчера")) {
                        article.setDate(LocalDateTime.of(LocalDate.now().minusDays(1), LocalTime.parse(e.select("dfn").first().text())));
                    } else {
                        try {
                            final var localDate = LocalDate.parse(date, DateTimeFormatter.ofPattern("dd.MM.yyyy"));
                            article.setDate(LocalDateTime.of(localDate, LocalTime.parse(e.select("dfn").first().text())));
                        } catch (Exception ex) {
                            log.error(String.format("Could not parse date of article: %s", date), ex);
                            article.setDate(LocalDateTime.of(LocalDate.now().minusDays(2), LocalTime.parse(e.select("dfn").first().text())));
                        }
                    }

                    articles.add(article);
                }
            }

            if (CollectionUtils.isEmpty(articles)) {
                log.error("There are no articles");
            } else {
                log.info("Parsed {} articles from bessarabia inform", articles.size());
            }

            return articles;
        } catch (IOException e) {
            log.error(String.format("Could not connect to url: %s", url), e);
            return Collections.emptyList();
        }
    }
}
