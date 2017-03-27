package com.owuteam.topic;

import com.owuteam.core.ResponseStatus;

import java.util.List;

public interface TopicService {
    ResponseStatus deleteTopics(List<Long> ids);
}
