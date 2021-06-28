package com.nb.news.bessarabianinform.domain;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author Nick Barban.
 */
@Data
// TODO by nbarban: 28/06/21 Should be moved to common
public class Article {
    private String link;
    private LocalDateTime date;
    private String title;
}
