package com.owuteam.news;

import com.owuteam.core.ResponseStatus;
import com.owuteam.tags.Tag;
import com.owuteam.tags.TagRepository;
import com.owuteam.topic.Topic;
import com.owuteam.topic.TopicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

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

    @Override
    public Topic addTopic(Long id, Topic topic) {
        News news = newsRepository.findById(id);

        Topic result = topicRepository.findById(topic.getId());
        news.setTopic(result);
        topicRepository.save(result);
        return result;
    }

    @Override
    public ResponseStatus addTag(Long id, Tag tag) {
        News news = newsRepository.findById(id);
        Tag result = tagRepository.findById(tag.getId());
        boolean fl = false;
        for (Tag temp : news.getTags()) {
            if (temp.getId().equals(result.getId())) {
                fl = true;
                break;
            }
        }
        if (!fl) {
            news.addTag(result);
            newsRepository.save(news);
        }
        return new ResponseStatus(true);
    }

    @Override
    public ResponseStatus deleteNews(List<Long> ids) {
        for (Long id : ids) {
            newsRepository.delete(id);
        }
        return new ResponseStatus(true);
    }

    @Override
    public ResponseEntity<?> getNewsItem(Long id) {
        News news = newsRepository.findOne(id);
        if (news == null) {
            return new ResponseEntity<>(new ResponseStatus(false), HttpStatus.NOT_FOUND);
        }
        news.incrementViews();
        return new ResponseEntity<>(newsRepository.save(news), HttpStatus.CREATED);
    }
}
