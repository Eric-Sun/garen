package com.j13.v2.server.vos;

import com.j13.v2.server.poppy.anno.Parameter;

public class CommentAddResp {
    @Parameter(desc="评论id")
    private int cid;

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }
}
