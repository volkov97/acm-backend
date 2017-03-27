package com.owuteam.core;

import java.util.List;

public class CustomDeleteByIdsRequest {
    private List<Long> ids;

    public CustomDeleteByIdsRequest() {}

    public List<Long> getIds() {
        return ids;
    }

    public void setIds(List<Long> ids) {
        this.ids = ids;
    }
}
