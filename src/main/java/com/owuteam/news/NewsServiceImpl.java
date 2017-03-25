package com.owuteam.news;

import com.owuteam.tags.Tag;
import com.owuteam.tags.TagRepository;
import com.owuteam.topic.Topic;
import com.owuteam.topic.TopicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NewsServiceImpl implements NewsService {

    private TopicRepository topicRepository;
    private NewsRepository newsRepository;
    private TagRepository tagRepository;

    @Autowired
    public NewsServiceImpl(TopicRepository topicRepository, NewsRepository newsRepository, TagRepository tagRepository) {
        this.topicRepository = topicRepository;
        this.newsRepository = newsRepository;
        this.tagRepository = tagRepository;
    }




//    @Override
//    public Long addTopic(Long id, Topic topic) {
//        final long ERR = -1;
//        News news = newsRepository.findById(id);
//        if (news == null) {
//            return ERR;
//        }
//        Topic result = topicRepository.findByNameRUAndNameEN(topic.getNameRU(), topic.getNameEN());
//        if (result == null) {
//            result = topic;
//        }
//        //newsRepository.save(news);
//        news.setTopic(result);
//        topicRepository.save(result);
//
//        return result.getId();
//    }

    @Override
    public Topic addTopic(Long id, Topic topic) {
        News news = newsRepository.findById(id);

        Topic result = topicRepository.findById(topic.getId());
        news.setTopic(result);
        topicRepository.save(result);
        return result;
    }

    @Override
    public Long addTag(Long id, Tag tag) {
        return new Long(-1);
    }

}
