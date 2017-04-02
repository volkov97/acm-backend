package com.owuteam.tags;

import com.owuteam.core.ResponseStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TagServiceImpl implements TagService {

    private final TagRepository tagRepository;

    @Autowired
    public TagServiceImpl(TagRepository tagRepository) {
        this.tagRepository = tagRepository;
    }

    @Override
    public ResponseStatus deleteTags(List<Long> ids) {
        for (Long id : ids) {
            tagRepository.delete(id);
        }
        return new ResponseStatus(true);
    }
}
