package com.j13.garen.facade.resp;

import com.j13.garen.poppy.anno.Parameter;

public class UserRegisterResp {
    @Parameter(desc="用户id")
    private long id;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}