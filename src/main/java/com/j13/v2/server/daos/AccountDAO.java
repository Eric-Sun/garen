package com.j13.v2.server.daos;

import com.j13.v2.server.core.Constants;
import com.j13.v2.server.poppy.util.BeanUtils;
import com.j13.v2.server.vos.PainterVO;
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

@Repository
public class AccountDAO {


    @Autowired
    JdbcTemplate j;

    public int add(final String accountName, final String password, final int authorityId) {
        KeyHolder holder = new GeneratedKeyHolder();
        final String sql = "insert into account " +
                "(name,password,createtime) " +
                "values" +
                "(?,?,now())";
        j.update(new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                final PreparedStatement pstmt = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
                pstmt.setString(1, accountName);
                pstmt.setString(2, password);
                return pstmt;
            }
        }, holder);
        final int accountId = holder.getKey().intValue();

        // 给account赋权
        final String authSql = "insert into account_authority " +
                "(account_id,authority_id,createtime) " +
                "values" +
                "(?,?,now())";

        j.update(new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                final PreparedStatement pstmt = connection.prepareStatement(authSql, PreparedStatement.RETURN_GENERATED_KEYS);
                pstmt.setInt(1, accountId);
                pstmt.setInt(2, authorityId);
                return pstmt;
            }
        }, holder);
        return accountId;
    }


    public void delete(int accountId) {
        String updateAccountAuthoritySql = "update account_authority set deleted= ? where account_id=?";
        j.update(updateAccountAuthoritySql, new Object[]{Constants.DB.DELETED, accountId});

        String updateAccountSql = "update account set deleted=? where account_id=?";
        j.update(updateAccountSql, new Object[]{Constants.DB.DELETED, accountId});
    }

    public PainterVO getPainter(int accountId) {
        String sql = "select name from account where account_id=?";
        PainterVO vo = j.queryForObject(sql, new Object[]{accountId}, new RowMapper<PainterVO>() {
            @Override
            public PainterVO mapRow(ResultSet rs, int rowNum) throws SQLException {
                PainterVO vo = new PainterVO();
                vo.setName(rs.getString(1));
                return vo;
            }
        });

        // 查询painterinfo
        String painterInfoSql = "select brief,mobile,real_name from painter_info where account_id=?";
        PainterVO vo2 = j.queryForObject(painterInfoSql, new Object[]{accountId}, new RowMapper<PainterVO>() {
            @Override
            public PainterVO mapRow(ResultSet rs, int rowNum) throws SQLException {
                PainterVO vo = new PainterVO();
                vo.setBreif(rs.getString(1));
                vo.setMobile(rs.getString(2));
                vo.setRealName(rs.getString(3));
                return vo;
            }
        });

        BeanUtils.copyProperties(vo, vo2);
        return vo;
    }


}
