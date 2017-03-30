package com.j13.v2.server.facade.req;

import com.j13.v2.server.poppy.anno.Parameter;

public class SetMachineUserToDZReq {
    @Parameter(desc="此次一共获取多少个")
    private int size;

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}
