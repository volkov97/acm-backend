package com.owuteam.page;

import com.owuteam.core.ResponseStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PageServiceImpl implements PageService {

    private final PageRepository pageRepository;

    @Autowired
    public PageServiceImpl(PageRepository pageRepository) {
        this.pageRepository = pageRepository;
    }

    @Override
    public ResponseStatus deletePages(List<Long> ids) {
        for (Long id : ids) {
            pageRepository.delete(id);
        }
        return new ResponseStatus(true);
    }
}
