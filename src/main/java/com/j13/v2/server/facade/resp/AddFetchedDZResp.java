package com.j13.v2.server.facade.resp;

import com.j13.v2.server.poppy.anno.Parameter;

public class AddFetchedDZResp {
    @Parameter
    private long id;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
