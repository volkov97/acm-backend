package com.owuteam.section;

import com.owuteam.core.ResponseStatus;
import com.owuteam.page.Page;

import java.util.List;

public interface ChampSectionService {
    ResponseStatus addPage(Long id, Page page);
    ResponseStatus deleteSections(List<Long> ids);
}
