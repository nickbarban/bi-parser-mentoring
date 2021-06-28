package com.nb.news.bessarabianinform.service;

import com.github.javafaker.Faker;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Implementation for {@link NewsParser}.
 *
 * @author Nick Barban.
 */
@Service
public class NewsParserImpl implements NewsParser {
    private static final Faker FAKER = Faker.instance();

    @Override
    public List<String> getNews() {
        return FAKER.lorem().paragraphs(FAKER.number().numberBetween(1, 5));
    }
}
