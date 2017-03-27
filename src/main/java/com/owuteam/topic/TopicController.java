package com.owuteam.topic;

import com.owuteam.core.*;
import com.owuteam.core.ResponseStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class TopicController {

    private final TopicService topicService;

    @Autowired
    public TopicController(TopicService topicService) {
        this.topicService = topicService;
    }

    @RequestMapping(value = "/topics/delete", method = RequestMethod.DELETE)
    public ResponseStatus deleteTopics(@RequestBody CustomDeleteByIdsRequest req)  {
        return topicService.deleteTopics(req.getIds());
    }
}
