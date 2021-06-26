package com.nb.news.bessarabianinform;

import com.github.javafaker.Faker;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@SpringBootApplication
@RestController
public class BessarabianinformApplication {

    private static final Faker FAKER = new Faker();

    public static void main(String[] args) {
        SpringApplication.run(BessarabianinformApplication.class, args);
    }

    @GetMapping
    public List<String> getNews() {
        return IntStream.range(0, FAKER.number().numberBetween(1, 10))
                .mapToObj(i -> FAKER.lorem().paragraph(FAKER.number().numberBetween(1, 3)))
                .collect(Collectors.toList());
    }

}
