package com.j13.garen.facade.resp;

import com.j13.garen.poppy.anno.Parameter;

public class UserLoginResp {
    @Parameter(desc="用户id")
    private long userId;

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

}
