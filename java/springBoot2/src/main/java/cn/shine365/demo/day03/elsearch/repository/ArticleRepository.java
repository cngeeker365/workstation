package cn.shine365.demo.day03.elsearch.repository;

import cn.shine365.demo.day03.elsearch.domain.Article;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;


@Component 
//@Repository
public interface ArticleRepository extends ElasticsearchRepository<Article, Long> {
}