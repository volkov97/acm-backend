package com.owuteam.topic;

import com.owuteam.core.ResponseStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TopicServiceImpl implements TopicService {

    private final TopicRepository topicRepository;

    @Autowired
    public TopicServiceImpl(TopicRepository topicRepository) {
        this.topicRepository = topicRepository;
    }

    @Override
    public ResponseStatus deleteTopics(List<Long> ids) {
        for (Long id : ids) {
            topicRepository.delete(id);
        }
        return new ResponseStatus(true);
    }
}
