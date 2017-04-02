package com.owuteam.section;

import com.owuteam.core.CustomDeleteByIdsRequest;
import com.owuteam.core.ResponseStatus;
import com.owuteam.page.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ChampSectionController {

    private final ChampSectionService champSectionService;

    @Autowired
    public ChampSectionController(ChampSectionService champSectionService) {
        this.champSectionService = champSectionService;
    }

    @RequestMapping(value = "/champSections/delete", method = RequestMethod.DELETE)
    public ResponseStatus deleteSections(@RequestBody CustomDeleteByIdsRequest req)  {
        return champSectionService.deleteSections(req.getIds());
    }

    @RequestMapping(value = "/champSections/{id}/bind/page", method = RequestMethod.POST)
    public ResponseStatus addPage(@PathVariable Long id, @RequestBody Page page)  {
        return champSectionService.addPage(id, page);
    }
}
