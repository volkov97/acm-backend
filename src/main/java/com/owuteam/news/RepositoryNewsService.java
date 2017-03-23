package com.owuteam.news;

import com.owuteam.tags.Tag;
import com.owuteam.topic.Topic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RepositoryNewsService implements NewsService {

    private NewsRepositoryCustom newsRepositoryCustom;

    @Autowired
    public RepositoryNewsService(NewsRepositoryCustom newsRepositoryCustom) {
        this.newsRepositoryCustom = newsRepositoryCustom;
    }

    @Override
    public Long addTopic(Long id, Topic topic) {
        return newsRepositoryCustom.addTopic(id, topic);
    }

    @Override
    public Long addTag(Long id, Tag tag) {
        return newsRepositoryCustom.addTag(id, tag);
    }
}
