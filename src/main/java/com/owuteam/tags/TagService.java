package com.owuteam.tags;


import com.owuteam.core.ResponseStatus;

import java.util.List;

public interface TagService {
    ResponseStatus deleteTags(List<Long> ids);
}
