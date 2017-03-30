package com.j13.v2.server.facade.req;

import com.j13.v2.server.poppy.anno.Parameter;

public class FavoriteAddReq {
    //Integer userId, Integer dzId
    @Parameter(desc="用户id")
    private int userId;
    @Parameter(desc="段子id")
    private int dzId;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getDzId() {
        return dzId;
    }

    public void setDzId(int dzId) {
        this.dzId = dzId;
    }
}
