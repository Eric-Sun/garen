package com.j13.garen.daos;

import com.j13.garen.core.Constants;
import com.j13.garen.vos.AuthorityVO;
import com.j13.garen.vos.PainterVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
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
public class AccountDAO {


    @Autowired
    JdbcTemplate j;

    public int add(final String accountName, final String password, final int authorityId) {
        KeyHolder holder = new GeneratedKeyHolder();
        final String sql = "insert into account " +
                "(name,password,createtime,updatetime) " +
                "values" +
                "(?,?,now(),now())";
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
                "(account_id,authority_id,createtime,updatetime) " +
                "values" +
                "(?,?,now(),now())";

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
        String updateAccountAuthoritySql = "update account_authority set deleted= ?,updatetime=now() where account_id=?";
        j.update(updateAccountAuthoritySql, new Object[]{Constants.DB.DELETED, accountId});

        String updateAccountSql = "update account set deleted=?,updatetime=now() where id=?";
        j.update(updateAccountSql, new Object[]{Constants.DB.DELETED, accountId});
    }

    public PainterVO getPainter(int accountId) {
        String sql = "select a.name,p.brief,mobile,p.real_name,a.id from account a left outer join painter_info p on p.account_id=a.id where a.id=?";
        PainterVO vo = j.queryForObject(sql, new Object[]{accountId}, new RowMapper<PainterVO>() {
            @Override
            public PainterVO mapRow(ResultSet rs, int rowNum) throws SQLException {
                PainterVO vo = new PainterVO();
                vo.setAccountName(rs.getString(1));
                vo.setBrief(rs.getString(2));
                vo.setMobile(rs.getString(3));
                vo.setRealName(rs.getString(4));
                vo.setAccountId(rs.getInt(5));
                return vo;
            }
        });
        return vo;
    }


    public int getAuthorityIdByName(String name) {
        String sql = "select a.id from account u , authority a, account_authority ua " +
                " where u.name=? and u.id=ua.account_id and ua.authority_id = a.id";
        return j.queryForObject(sql, new Object[]{name}, Integer.class);
    }

    public int getAccountIdByName(String name) {
        String sql = "select id from account where name=?";
        return j.queryForObject(sql, new Object[]{name}, Integer.class);
    }
}
