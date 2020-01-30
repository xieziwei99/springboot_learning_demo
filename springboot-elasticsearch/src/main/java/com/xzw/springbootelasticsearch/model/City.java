package com.xzw.springbootelasticsearch.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

/**
 * @author xieziwei99
 * 2020-01-30
 */

@Data
@Document(indexName = "city", shards = 1, type = "_doc")
public class City {
    @Id
    private Long id;
    private Long provinceId;
    private String cityName;
    private String description;
}
