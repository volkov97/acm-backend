package com.owuteam.news;

import com.owuteam.tags.Tag;
import com.owuteam.topic.Topic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class NewsRestController {

    private NewsService newsService;

    @Autowired
    public NewsRestController(NewsService newsService) {
        this.newsService = newsService;
    }

    @RequestMapping(value = "/news/{id}/topic", method = RequestMethod.POST)
    public Long addTopic(@PathVariable Long id, @RequestBody Topic topic)  {
        return newsService.addTopic(id, topic);
    }

    @RequestMapping(value = "/news/{id}/tag", method = RequestMethod.POST)
    public Long addTag(@PathVariable Long id, @RequestBody Tag tag)  {
        return newsService.addTag(id, tag);
    }
}
