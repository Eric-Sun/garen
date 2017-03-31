package com.j13.v2.server.facade;

import com.j13.v2.server.daos.AccountDAO;
import com.j13.v2.server.daos.PainterInfoDAO;
import com.j13.v2.server.facade.req.*;
import com.j13.v2.server.facade.resp.PainterAddResp;
import com.j13.v2.server.facade.resp.PainterGetResp;
import com.j13.v2.server.facade.resp.PainterListResp;
import com.j13.v2.server.facade.resp.PainterSimpleResp;
import com.j13.v2.server.poppy.anno.Action;
import com.j13.v2.server.poppy.core.CommandContext;
import com.j13.v2.server.poppy.core.CommonResultResp;
import com.j13.v2.server.poppy.util.BeanUtils;
import com.j13.v2.server.vos.PainterVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PainterFacade {

    private static Logger LOG = LoggerFactory.getLogger(PainterFacade.class);

    @Autowired
    AccountDAO accountDAO;
    @Autowired
    PainterInfoDAO painterInfoDAO;


    @Action(name = "painter.add", desc = "创建画师，admin来调用")
    public PainterAddResp add(CommandContext ctxt, PainterAddReq req) {
        PainterAddResp resp = new PainterAddResp();

        String accountName = req.getAccountName();
        String password = req.getPassword();
        String brief = req.getBrief();
        String mobile = req.getMobile();
        String realName = req.getRealName();
        int authorityId = req.getAuthorityId();

        // 创建账号并且赋权
        int accountId = accountDAO.add(accountName, password, authorityId);

        // 插入画师信息
        int painterInfoId = painterInfoDAO.add(accountId, mobile, brief, realName);
        LOG.info("Painter added. accountId = {}, painterInfoId = {}", accountId, painterInfoId);
        resp.setId(accountId);
        return resp;
    }


    @Action(name = "painter.get", desc = "获取画师相关信息")
    public PainterGetResp get(CommandContext ctxt, PainterGetReq req) {
        PainterGetResp resp = new PainterGetResp();
        int accountId = req.getAccountId();
        PainterVO vo = accountDAO.getPainter(accountId);
        BeanUtils.copyProperties(resp, vo);
        return resp;
    }


    @Action(name = "painter.delete", desc = "删除画师")
    public CommonResultResp delete(CommandContext ctxt, PainterDeleteReq req) {
        CommonResultResp resp = new CommonResultResp();
        int accountId = req.getAccountId();
        accountDAO.delete(accountId);
        painterInfoDAO.delete(accountId);
        return resp;
    }

    @Action(name = "painter.update", desc = "修改画师信息")
    public CommonResultResp update(CommandContext ctxt, PainterUpdateReq req) {
        CommonResultResp resp = new CommonResultResp();
        int accountId = req.getAccountId();
        String mobile = req.getMobile();
        String realName = req.getRealName();
        String brief = req.getBrief();
        painterInfoDAO.update(accountId, mobile, brief, realName);
        return resp;
    }


    @Action(name = "painter.list", desc = "获取画师的列表")
    public PainterListResp list(CommandContext ctxt, PainterListReq req) {
        PainterListResp resp = new PainterListResp();
        int sizePerPage = req.getSizePerPage();
        int pageNum = req.getPageNum();
        List<PainterSimpleResp> respList = painterInfoDAO.list(sizePerPage, pageNum);
        resp.setList(respList);
        return resp;
    }


}
