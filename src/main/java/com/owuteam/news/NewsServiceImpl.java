package com.owuteam.news;

import com.owuteam.topic.Topic;
import com.owuteam.topic.TopicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Service
public class NewsServiceImpl implements NewsService {

    NewsRepository newsRepository;
    TopicRepository topicRepository;

    @Autowired
    public NewsServiceImpl(NewsRepository newsRepository, TopicRepository topicRepository) {
        this.newsRepository = newsRepository;
        this.topicRepository = topicRepository;
    }

    @Override
    @RequestMapping(value = "/news/{id}/topic", method = RequestMethod.POST)
    public Long addByTopic(@PathVariable("id") Long id, @Param("nameRU")  String nameRU, @Param("nameEN")  String nameEN) {

        News news = newsRepository.findById(id);
        Topic topic = new Topic(nameRU, nameEN);
        news.setTopic(topic);
        newsRepository.save(news);
        topicRepository.save(topic);

        return topic.getId();
    }
}
