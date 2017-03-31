package com.j13.v2.server.daos;

import com.j13.v2.server.core.Constants;
import com.j13.v2.server.facade.resp.PainterSimpleResp;
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
public class PainterInfoDAO {

    @Autowired
    JdbcTemplate j;


    public int add(final int accountId, final String mobile, final String brief, final String realName) {
        KeyHolder holder = new GeneratedKeyHolder();
        final String sql = "insert into painter_info " +
                "(account_id,brief,mobile,real_name,createtime) " +
                "values" +
                "(?,?,?,?now())";

        j.update(new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                final PreparedStatement pstmt = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
                pstmt.setInt(1, accountId);
                pstmt.setString(2, mobile);
                pstmt.setString(3, brief);
                pstmt.setString(4, realName);
                return pstmt;
            }
        }, holder);
        return holder.getKey().intValue();
    }

    public void delete(int accountId) {
        String sql = "update painter_info set deleted=? where account_id=?";
        j.update(sql, new Object[]{Constants.DB.DELETED, accountId});
    }

    public void update(int accountId, String mobile, String brief, String realName) {
        String sql = "update painter_info set mobile=? , brief=? and real_name=? where account_id=?";
        j.update(sql, new Object[]{mobile, brief, realName, accountId});
    }


    public List<PainterSimpleResp> list(int sizePerPage, int pageNum) {

        String sql = "select account_id,real_name from painter_info limit ?,?";
        List<PainterSimpleResp> list = j.query(sql, new Object[]{pageNum * sizePerPage, sizePerPage}, new RowMapper<PainterSimpleResp>() {
            @Override
            public PainterSimpleResp mapRow(ResultSet rs, int rowNum) throws SQLException {
                PainterSimpleResp resp = new PainterSimpleResp();
                resp.setAccountId(rs.getInt(1));
                resp.setRealName(rs.getString(2));
                return resp;
            }
        });

        return list;
    }
}
