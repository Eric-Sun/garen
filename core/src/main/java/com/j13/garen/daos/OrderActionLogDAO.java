package com.j13.garen.daos;

import com.j13.garen.vos.OrderActionLogVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class OrderActionLogDAO {

    @Autowired
    JdbcTemplate j;


    public void add(final int accountId, final int actionType, final String content) {
        final String sql = "insert into order_action_log " +
                "(account_id,action_type,content,createtime,updatetime) " +
                "values" +
                "(?,?,?,now(),now())";
        j.update(new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                final PreparedStatement pstmt = connection.prepareStatement(sql);
                pstmt.setInt(1, accountId);
                pstmt.setInt(2, actionType);
                pstmt.setString(3, content);
                return pstmt;
            }
        });
    }

    public List<OrderActionLogVO> list(int sizePerPage, int pageNum) {
        String sql = "select account_id,action_type,content,createtime from order_action_log where deleted=? limit ?,?";
        return j.query(sql, new Object[]{}, new RowMapper<OrderActionLogVO>() {
            @Override
            public OrderActionLogVO mapRow(ResultSet rs, int rowNum) throws SQLException {
                OrderActionLogVO vo =  new OrderActionLogVO();
                vo.setAccountId(rs.getInt(1));
                vo.setActionType(rs.getInt(2));
                vo.setContent(rs.getString(3));
                vo.setCreatetime(rs.getDate(4).getTime());
                return vo;
            }
        });
    }

}
