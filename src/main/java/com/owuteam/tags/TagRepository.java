package com.owuteam.tags;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface TagRepository extends CrudRepository<Tag, Long> {
    Tag findByNameRUAndNameEN(@Param("nameRU") String nameRU, @Param("nameEN") String nameEN);
    Tag findById(@Param("id") Long id);
}
