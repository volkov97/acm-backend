package com.owuteam.tags;

import com.owuteam.core.CustomDeleteByIdsRequest;
import com.owuteam.core.ResponseStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TagController {

    private final TagService tagService;

    @Autowired
    public TagController(TagService tagService) {
        this.tagService = tagService;
    }

    @RequestMapping(value = "/tags/delete", method = RequestMethod.DELETE)
    public ResponseStatus deleteChamps(@RequestBody CustomDeleteByIdsRequest req)  {
        return tagService.deleteTags(req.getIds());
    }
}
