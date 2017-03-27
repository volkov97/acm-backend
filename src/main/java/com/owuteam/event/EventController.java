package com.owuteam.event;

import com.owuteam.core.CustomDeleteByIdsRequest;
import com.owuteam.core.ResponseStatus;
import com.owuteam.topic.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EventController {

    private final EventService eventService;

    @Autowired
    public EventController(EventService eventService) {
        this.eventService = eventService;
    }

    @RequestMapping(value = "/events/delete", method = RequestMethod.DELETE)
    public ResponseStatus deleteTopics(@RequestBody CustomDeleteByIdsRequest req)  {
        return eventService.deleteEvents(req.getIds());
    }
}
