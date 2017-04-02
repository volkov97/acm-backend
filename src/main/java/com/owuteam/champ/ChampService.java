package com.owuteam.champ;

import com.owuteam.core.ResponseStatus;
import com.owuteam.section.ChampSection;
import org.springframework.stereotype.Service;

import java.util.List;

public interface ChampService {
    ResponseStatus addSection(Long id, ChampSection section);
    ResponseStatus deleteChamps(List<Long> ids);
}
