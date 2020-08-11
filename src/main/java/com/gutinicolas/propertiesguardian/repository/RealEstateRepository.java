package com.gutinicolas.propertiesguardian.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.Map;

public interface RealEstateRepository extends ElasticsearchRepository<Map<String, Object>, String> {

    Page<Map<String, Object>> findByRealEstateName(String name, Pageable pageable);

    @Query("{\"bool\": {\"must\": [{\"match\": {\"realestates.id\": \"?0\"}}]}}")
    Page<Map<String, Object>> findById(String id, Pageable pageable);
}
