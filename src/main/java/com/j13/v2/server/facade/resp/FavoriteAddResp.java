package com.j13.v2.server.facade.resp;

import com.j13.v2.server.poppy.anno.Parameter;

public class FavoriteAddResp {
    @Parameter(desc="收藏id")
    private long fid;

    public long getFid() {
        return fid;
    }

    public void setFid(long fid) {
        this.fid = fid;
    }
}
