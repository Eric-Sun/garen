package com.j13.garen.facade;

import com.j13.garen.core.ErrorCode;
import com.j13.garen.daos.ItemDAO;
import com.j13.garen.facade.req.*;
import com.j13.garen.facade.resp.ItemAddResp;
import com.j13.garen.facade.resp.ItemGetResp;
import com.j13.garen.facade.resp.ItemListResp;
import com.j13.garen.poppy.anno.Action;
import com.j13.garen.poppy.core.CommandContext;
import com.j13.garen.poppy.core.CommonResultResp;
import com.j13.garen.poppy.exceptions.CommonException;
import com.j13.garen.poppy.util.BeanUtils;
import com.j13.garen.vos.ItemVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ItemFacade {


    @Autowired
    ItemDAO itemDAO;

    @Action(name = "item.add", desc = "添加一个商品")
    public ItemAddResp add(CommandContext ctxt, ItemAddReq req) {
        ItemAddResp resp = new ItemAddResp();

        String name = req.getName();
        float price = req.getPrice();
        int id = itemDAO.add(name, price);
        resp.setItemId(id);
        return resp;
    }

    @Action(name = "item.delete", desc = "delete a item by itemId")
    public CommonResultResp delete(CommandContext ctxt, ItemDeleteReq req) {
        CommonResultResp resp = new CommonResultResp();
        itemDAO.delete(req.getItemId());
        return resp;
    }

    @Action(name = "item.update", desc = "update a item")
    public CommonResultResp update(CommandContext ctxt, ItemUpdateReq req) {
        CommonResultResp resp = new CommonResultResp();
        itemDAO.update(req.getItemId(), req.getName(), req.getPrice());
        return resp;
    }

    @Action(name = "item.get", desc = "get a item info")
    public ItemGetResp get(CommandContext ctxt, ItemGetReq req) {
        ItemGetResp resp = new ItemGetResp();
        ItemVO item = null;
        try {
            item = itemDAO.get(req.getItemId());
        } catch (EmptyResultDataAccessException e) {
            throw new CommonException(ErrorCode.Item.NO_ITEM_RETURN);
        }
        BeanUtils.copyProperties(resp, item);
        resp.setItemId(req.getItemId());
        return resp;
    }

    @Action(name = "item.list", desc = "query a item list. ")
    public ItemListResp list(CommandContext ctxt, ItemListReq req) {
        ItemListResp resp = new ItemListResp();
        List<ItemVO> itemVOList = itemDAO.list(req.getSizePerPage(), req.getPageNum());
        for (ItemVO vo : itemVOList) {
            ItemGetResp r = new ItemGetResp();
            BeanUtils.copyProperties(r, vo);
            resp.getList().add(r);
        }
        return resp;
    }

}
