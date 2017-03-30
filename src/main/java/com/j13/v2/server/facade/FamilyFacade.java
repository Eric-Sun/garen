package com.j13.v2.server.facade;

import com.j13.v2.server.facade.req.CommentAddMachineReq;
import com.j13.v2.server.facade.resp.FamilyAddResp;
import com.j13.v2.server.poppy.anno.Action;
import com.j13.v2.server.poppy.core.CommandContext;
import org.springframework.stereotype.Component;

@Component
public class FamilyFacade {


    @Action(name = "family.add",
            desc = "添加家族")
    public FamilyAddResp add(CommandContext ctxt, CommentAddMachineReq req) {
        FamilyAddResp resp = new FamilyAddResp();

        return resp;
    }

}
