package com.owuteam.section;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChampSectionRepository extends CrudRepository<ChampSection, Long> {
}
