package com.owuteam.event;

import com.owuteam.core.ResponseStatus;

import java.util.List;

public interface EventService {
    ResponseStatus deleteEvents(List<Long> ids);
}
