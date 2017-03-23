package com.owuteam.news;

import com.owuteam.tags.Tag;
import com.owuteam.topic.Topic;

public interface NewsRepositoryCustom {
    Long addTopic(Long id, Topic topic);
    Long addTag(Long id, Tag tag);
}
