package com.owuteam.news;

import com.owuteam.core.*;
import com.owuteam.core.ResponseStatus;
import com.owuteam.tags.Tag;
import com.owuteam.topic.Topic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.xml.ws.Response;

@RestController
public class NewsController {

    private NewsService newsService;

    @Autowired
    public NewsController(NewsService newsService) {
        this.newsService = newsService;
    }

    @RequestMapping(value = "/news/{id}/bind/topic", method = RequestMethod.POST)
    public Topic addTopic(@PathVariable Long id, @RequestBody Topic topic)  {
        return newsService.addTopic(id, topic);
    }

    @RequestMapping(value = "/news/{id}/bind/tag", method = RequestMethod.POST)
    public ResponseStatus addTag(@PathVariable Long id, @RequestBody Tag tag)  {
        return newsService.addTag(id, tag);
    }

    @RequestMapping(value = "/news/delete", method = RequestMethod.DELETE)
    public ResponseStatus deleteTopics(@RequestBody CustomDeleteByIdsRequest req)  {
        return newsService.deleteNews(req.getIds());
    }

    @RequestMapping(value = "/news/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> getNewsItem(@PathVariable Long id)  {
        return newsService.getNewsItem(id);
    }

    @RequestMapping(value = "/news/{id}", method = RequestMethod.PUT)
    public ResponseEntity<?> updateNewsItem(@PathVariable Long id)  {
        return new ResponseEntity<>(new ResponseStatus(true),
        HttpStatus.OK);
    }
}
