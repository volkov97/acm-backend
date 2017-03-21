package com.owuteam.topic;

import com.owuteam.news.News;
import com.owuteam.news.NewsNotFoundException;
import com.owuteam.news.NewsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

@RestController
public class TopicRestController {
    private final NewsRepository newsRepository;
    private final TopicRepository topicRepository;

    @Autowired
    public TopicRestController(NewsRepository newsRepository, TopicRepository topicRepository) {
        this.newsRepository = newsRepository;
        this.topicRepository = topicRepository;
    }

    @RequestMapping(value = "/news/{id}/topic", method = RequestMethod.POST)
    Long addTopic(@PathVariable Long id, @RequestBody Topic topic)  {
        final long ERR = -1;
        News news = newsRepository.findById(id);
        if(news == null) {
            return ERR;
        }
        Topic result = topicRepository.findByNameRUAndNameEN(topic.getNameRU(), topic.getNameEN());
        if(result == null) {
            result = topic;
        }
        //newsRepository.save(news);
        news.setTopic(result);
        topicRepository.save(result);

        return topic.getId();
    }
}
