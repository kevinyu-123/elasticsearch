package com.study.elastic.repository;

import com.study.elastic.entity.ItemDocument;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemRepository extends ElasticsearchRepository<ItemDocument, Long> {

    List<ItemDocument> findAll();

    List<ItemDocument> findAllByName(String name);

    List<ItemDocument> findAllByUsage(int usage);

    List<ItemDocument> findAllByDescription(String description);



}
