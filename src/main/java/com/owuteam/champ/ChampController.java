package com.owuteam.champ;

import com.owuteam.core.CustomDeleteByIdsRequest;
import com.owuteam.core.ResponseStatus;
import com.owuteam.section.ChampSection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ChampController {

    private final ChampService champService;

    @Autowired
    public ChampController(ChampService champService) {
        this.champService = champService;
    }

    @RequestMapping(value = "/champs/delete", method = RequestMethod.DELETE)
    public ResponseStatus deleteChamps(@RequestBody CustomDeleteByIdsRequest req)  {
        return champService.deleteChamps(req.getIds());
    }

    @RequestMapping(value = "/champs/{id}/bind/champSection", method = RequestMethod.POST)
    public ResponseStatus addSection(@PathVariable Long id, @RequestBody ChampSection champSection)  {
        return champService.addSection(id, champSection);
    }
}
