package com.owuteam.section;

import com.owuteam.core.ResponseStatus;
import com.owuteam.page.Page;
import com.owuteam.page.PageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ChampSectionServiceImpl implements ChampSectionService {

    private final ChampSectionRepository champSectionRepository;
    private final PageRepository pageRepository;

    @Autowired
    public ChampSectionServiceImpl(ChampSectionRepository champSectionRepository, PageRepository pageRepository) {
        this.champSectionRepository = champSectionRepository;
        this.pageRepository = pageRepository;
    }

    @Override
    public ResponseStatus addPage(Long id, Page page) {
        ChampSection champSection = champSectionRepository.findOne(id);
        Page tempPage = pageRepository.findOne(page.getId());

        if (champSection == null || tempPage == null) {
            return new ResponseStatus();
        }
        champSection.addPage(tempPage);
        champSectionRepository.save(champSection);
        return new ResponseStatus(true);
    }

    @Override
    public ResponseStatus deleteSections(List<Long> ids) {
        for (Long id : ids) {
            champSectionRepository.delete(id);
        }
        return new ResponseStatus(true);
    }
}
