package com.j13.v2.server.daos;

import com.j13.v2.server.core.Constants;
import com.j13.v2.server.vos.ItemVO;
import com.j13.v2.server.vos.OrderVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class OrderDAO {


    @Autowired
    JdbcTemplate j;

    public int add(final int userId, final int itemId, final float finalPrice, final int status) {
        KeyHolder holder = new GeneratedKeyHolder();
        final String sql = "insert into order " +
                "(user_id,item_id,final_price,status,createtime) " +
                "values" +
                "(?,?,?,?,now())";
        j.update(new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                final PreparedStatement pstmt = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
                pstmt.setInt(1, userId);
                pstmt.setInt(2, itemId);
                pstmt.setFloat(3, finalPrice);
                pstmt.setInt(4, status);
                return pstmt;
            }
        }, holder);
        final int accountId = holder.getKey().intValue();
        return accountId;
    }


    public void delete(int orderId) {
        String sql = "update order set deleted=? where id=?";
        j.update(sql, new Object[]{Constants.DB.DELETED, orderId});
    }

    public void updateBasicInfo(int orderId, int itemId, float finalPrice) {
        String sql = "update order set item_id=?,final_price=? where id=?";
        j.update(sql, new Object[]{itemId, finalPrice, orderId});
    }

    public void updateStatus(int orderId, int status) {
        String sql = "update order set status=? where order_id=?";
        j.update(sql, new Object[]{status, orderId});
    }

    public OrderVO get(int orderId) {
        String sql = "select o.user_id,o.item_id,o.final_price,o.status,i.name,u.name from order o left outer join user u on u.id=o.user_id left outer join item i on i.id=o.item_id where o.id=?";
        return j.queryForObject(sql, new Object[]{orderId}, new RowMapper<OrderVO>() {
            @Override
            public OrderVO mapRow(ResultSet rs, int rowNum) throws SQLException {
                OrderVO vo = new OrderVO();
                vo.setUserId(rs.getInt(1));
                vo.setItemId(rs.getInt(2));
                vo.setFinalPrice(rs.getFloat(3));
                vo.setStatus(rs.getInt(4));
                vo.setUserName(rs.getString(5));
                vo.setItemName(rs.getString(6));
                return vo;
            }
        });
    }


    public List<OrderVO> list(int sizePerPage, int pageNum) {
        String sql = "select o.user_id,o.item_id,o.final_price,o.status,i.name,u.name from order o left outer join user u on u.id=o.user_id left outer join item i on i.id=o.item_id limit ?,? ";
        return j.query(sql, new Object[]{sizePerPage * pageNum, sizePerPage}, new RowMapper<OrderVO>() {
            @Override
            public OrderVO mapRow(ResultSet rs, int rowNum) throws SQLException {
                OrderVO vo = new OrderVO();
                vo.setUserId(rs.getInt(1));
                vo.setItemId(rs.getInt(2));
                vo.setFinalPrice(rs.getFloat(3));
                vo.setStatus(rs.getInt(4));
                vo.setUserName(rs.getString(5));
                vo.setItemName(rs.getString(6));
                return vo;
            }
        });
    }

    public List<OrderVO> list(int sizePerPage, int pageNum, int status) {
        String sql = "select o.user_id,o.item_id,o.final_price,o.status,i.name,u.name from order o left outer join user u on u.id=o.user_id left outer join item i on i.id=o.item_id where status=? limit ?,? ";
        return j.query(sql, new Object[]{status, sizePerPage * pageNum, sizePerPage}, new RowMapper<OrderVO>() {
            @Override
            public OrderVO mapRow(ResultSet rs, int rowNum) throws SQLException {
                OrderVO vo = new OrderVO();
                vo.setUserId(rs.getInt(1));
                vo.setItemId(rs.getInt(2));
                vo.setFinalPrice(rs.getFloat(3));
                vo.setStatus(rs.getInt(4));
                vo.setUserName(rs.getString(5));
                vo.setItemName(rs.getString(6));
                return vo;
            }
        });
    }


}
