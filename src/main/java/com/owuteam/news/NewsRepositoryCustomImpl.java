package com.owuteam.news;

import com.owuteam.tags.Tag;
import com.owuteam.tags.TagRepository;
import com.owuteam.topic.Topic;
import com.owuteam.topic.TopicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class NewsRepositoryCustomImpl implements NewsRepositoryCustom {

    private TopicRepository topicRepository;
    private NewsRepository newsRepository;
    private TagRepository tagRepository;

    @Autowired
    public NewsRepositoryCustomImpl(TopicRepository topicRepository, NewsRepository newsRepository, TagRepository tagRepository) {
        this.topicRepository = topicRepository;
        this.newsRepository = newsRepository;
        this.tagRepository = tagRepository;
    }

    public Long addTopic(Long id, Topic topic)  {
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

        return result.getId();
    }

    @Override
    public Long addTag(Long id, Tag tag) {
        return new Long(-1);
    }

//    @Override
//    public Long addTag(Long id, Tag tag) {
//        final long ERR = -1;
//        final int START = 0;
//        News news = newsRepository.findById(id);
//        if(news == null) {
//            return ERR;
//        }
//
//        Tag result = tagRepository.findByNameRUAndNameEN(tag.getNameRU(), tag.getNameEN());
//        if(result != null) {
//            boolean fl = false;
//            for (Tag x : news.getTags()) {
//                if (x.getId().equals(result.getId())) {
//                    fl = true;
//                    break;
//                }
//            }
//            if (fl) {
//                return result.getId();
//            } else {
//                news.addTag(result);
//                tagRepository.save(result);
//                return result.getId();
//            }
//        }
//        news.addTag(tag);
//        tagRepository.save(tag);
//        return tag.getId();
//    }
}
