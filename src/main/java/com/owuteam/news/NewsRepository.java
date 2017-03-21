package com.owuteam.news;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NewsRepository extends PagingAndSortingRepository<News, Long> {

    List<News> findByTitleRU(@Param("titleRU") String titleRU);

    List<News> findByTopicNameEN(@Param("nameEN") String nameEN);
    List<News> findByTopicNameRU(@Param("nameRU") String nameRU);
    List<News> findBySystemName(@Param("systemName") String systemName);

    News findById(@Param("id") Long id);
}
