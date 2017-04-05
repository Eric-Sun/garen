package com.j13.garen.poppy.core;

import com.j13.garen.poppy.anno.Parameter;

public class CommonResultResp {
    @Parameter(desc = "操作结果成功为0，其他是失败")
    private int result = 0;

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }
}
