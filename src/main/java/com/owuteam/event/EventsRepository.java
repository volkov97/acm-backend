package com.owuteam.event;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EventsRepository extends PagingAndSortingRepository<Event, Long> {
    //List<Event> sortByLastModifiedAt();
}
