package com.j13.v2.server.facade.req;

import com.j13.v2.server.poppy.anno.Parameter;

public class SizeDZByDateReq {
    @Parameter(desc="时间 格式：MM/dd/yyyy")
    private String date;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
