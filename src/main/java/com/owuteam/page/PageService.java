package com.owuteam.page;

import com.owuteam.core.ResponseStatus;

import java.util.List;

public interface PageService {
    ResponseStatus deletePages(List<Long> ids);
}
