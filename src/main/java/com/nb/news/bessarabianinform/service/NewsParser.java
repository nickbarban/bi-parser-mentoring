package com.nb.news.bessarabianinform.service;

import com.nb.news.bessarabianinform.domain.Article;

import java.util.List;

/**
 * @author Nick Barban.
 */
// TODO by nbarban: 26/06/21 Should be moved to common
public interface NewsParser {

    List<Article> getNews();
}
