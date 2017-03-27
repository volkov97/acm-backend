package com.owuteam.event;

import com.owuteam.core.ResponseStatus;
import com.owuteam.news.NewsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class EventServiceImpl implements EventService {
    private final EventsRepository eventsRepository;

    @Autowired
    public EventServiceImpl(EventsRepository eventsRepository) {
        this.eventsRepository = eventsRepository;
    }

    @Override
    public ResponseStatus deleteEvents(List<Long> ids) {
        for (Long id : ids) {
            eventsRepository.delete(id);
        }
        return new ResponseStatus(true);
    }
}
