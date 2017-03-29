package com.owuteam.champ;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChampRepository extends CrudRepository<Champ, Long> {
}
