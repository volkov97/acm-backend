package com.owuteam.topic;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface TopicRepository extends CrudRepository<Topic, Long> {
    Topic findById(@Param("id") Long id);
    Topic findByNameRUAndNameEN(@Param("nameRU") String nameRU, @Param("nameEN") String nameEN);
    Topic findByNameRU(@Param("nameRU") String nameRU);
}
