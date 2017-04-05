package com.j13.garen.facade;

import com.j13.garen.daos.AccountDAO;
import com.j13.garen.daos.ResourceDAO;
import com.j13.garen.facade.req.AccountGetAccountIdByNameReq;
import com.j13.garen.facade.req.AccountGetAuthorityByNameReq;
import com.j13.garen.facade.resp.AccountGetAccountIdByNameResp;
import com.j13.garen.facade.resp.AccountGetAuthorityByNameResp;
import com.j13.garen.poppy.anno.Action;
import com.j13.garen.poppy.core.CommandContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * facade for the account service.
 * some of interfaces only called by admin server.
 * TODO: will add the Admin annotation to handle it
 */
@Component
public class AccountFacade {

    @Autowired
    AccountDAO accountDAO;
    @Autowired
    ResourceDAO resourceDAO;

    @Action(name = "account.getAuthorityByName", desc = "Get all resource id configured by target accountName. Called by admin")
    public AccountGetAuthorityByNameResp getAuthorityByName(CommandContext ctxt, AccountGetAuthorityByNameReq req) {
        AccountGetAuthorityByNameResp resp = new AccountGetAuthorityByNameResp();
        String accountName = req.getName();
        int authorityId = accountDAO.getAuthorityIdByName(accountName);
        List<Integer> resourceIdList = resourceDAO.getResourceListByAuthorityId(authorityId);
        resp.setResourceIdList(resourceIdList);
        return resp;
    }


    @Action(name="account.getAccountIdByName",desc="Get Account Id by name. called by admin")
    public AccountGetAccountIdByNameResp getAccountIdByName(CommandContext ctxt, AccountGetAccountIdByNameReq req) {
        AccountGetAccountIdByNameResp resp = new AccountGetAccountIdByNameResp();
        String name = req.getName();
        int accountId = accountDAO.getAccountIdByName(name);
        resp.setAccountId(accountId);
        return resp;
    }

}
