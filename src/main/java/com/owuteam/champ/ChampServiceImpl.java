package com.owuteam.champ;

import com.owuteam.core.ResponseStatus;
import com.owuteam.section.ChampSection;
import com.owuteam.section.ChampSectionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChampServiceImpl implements ChampService{

    private final ChampRepository champRepository;
    private final ChampSectionRepository champSectionRepository;

    @Autowired
    public ChampServiceImpl(ChampRepository champRepository, ChampSectionRepository champSectionRepository) {
        this.champRepository = champRepository;
        this.champSectionRepository = champSectionRepository;
    }

    @Override
    public ResponseStatus addSection(Long id, ChampSection section) {
        Champ champ = champRepository.findOne(id);
        ChampSection champSection = champSectionRepository.findOne(section.getId());

        if (champ == null || champSection == null) {
            return new ResponseStatus();
        }
        champSection.setChamp(champ);
        champSectionRepository.save(champSection);
        return new ResponseStatus(true);
    }

    @Override
    public ResponseStatus deleteChamps(List<Long> ids) {
        for (Long id : ids) {
            champRepository.delete(id);
        }
        return new ResponseStatus(true);
    }


}
