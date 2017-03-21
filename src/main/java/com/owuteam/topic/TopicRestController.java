package com.owuteam.topic;

import com.owuteam.news.News;
import com.owuteam.news.NewsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/news/{id}/topic")
public class TopicRestController {
    private final NewsRepository newsRepository;
    private final TopicRepository topicRepository;

    @Autowired
    public TopicRestController(NewsRepository newsRepository, TopicRepository topicRepository) {
        this.newsRepository = newsRepository;
        this.topicRepository = topicRepository;
    }

    @RequestMapping(method = RequestMethod.POST)
    Long add(@PathVariable Long id, @RequestBody Topic topic) {

        News news = newsRepository.findById(id);
        news.setTopic(topic);
        //newsRepository.save(news);
        topicRepository.save(topic);

        return topic.getId();
    }
}
