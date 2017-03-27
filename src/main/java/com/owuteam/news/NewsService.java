package com.owuteam.news;

import com.owuteam.core.ResponseStatus;
import com.owuteam.tags.Tag;
import com.owuteam.topic.Topic;

import java.util.List;

public interface NewsService {
    Topic addTopic(Long id, Topic topic);
    ResponseStatus addTag(Long id, Tag tag);
    ResponseStatus deleteNews(List<Long> ids);
}
