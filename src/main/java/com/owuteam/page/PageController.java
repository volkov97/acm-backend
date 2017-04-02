package com.owuteam.page;

import com.owuteam.core.CustomDeleteByIdsRequest;
import com.owuteam.core.ResponseStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PageController {

    private final PageService pageService;

    @Autowired
    public PageController(PageService pageService) {
        this.pageService = pageService;
    }

    @RequestMapping(value = "/pages/delete", method = RequestMethod.DELETE)
    public ResponseStatus deletePage(@RequestBody CustomDeleteByIdsRequest req)  {
        return pageService.deletePages(req.getIds());
    }
}
