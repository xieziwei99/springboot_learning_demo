package com.xzw.springbootelasticsearch.model;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

/**
 * @author xieziwei99
 * 2020-01-30
 */
public interface UserESRepository extends ElasticsearchRepository<City, Long> {
    // 只要包含description中的词就行，甚至可以是倒序，例如“家的”可以匹配到“的家”
    List<City> findCityByDescription(String description);
}
