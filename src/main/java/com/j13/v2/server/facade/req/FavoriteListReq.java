package com.j13.v2.server.facade.req;

import com.j13.v2.server.poppy.anno.Parameter;

public class FavoriteListReq {
    @Parameter(desc="用户id")
    private int userId;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
