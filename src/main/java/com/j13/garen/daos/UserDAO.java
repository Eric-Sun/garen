package com.j13.garen.daos;

import com.j13.garen.vos.UserVO;
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

/**
 * Created with IntelliJ IDEA.
 * User: sunbo
 * Date: 14-3-19
 * Time: 下午4:22
 * To change this template use File | Settings | File Templates.
 */
@Repository
public class UserDAO {

    @Autowired
    JdbcTemplate j;


    public UserVO loginByMobile(String mobile, String password) {
        final String sql = "select id from user where mobile=? and password=?";
        UserVO vo = j.queryForObject(sql, new Object[]{mobile, password}, new RowMapper<UserVO>() {
            @Override
            public UserVO mapRow(ResultSet resultSet, int i) throws SQLException {
                UserVO vo = new UserVO();
                vo.setUserId(resultSet.getInt(1));
                return vo;
            }
        });
        return vo;

    }


    public long register(final String mobile, final String password) {
        KeyHolder holder = new GeneratedKeyHolder();
        final String sql = "insert into user(mobile,password,createtime,updatetime) values(?,?,now(),now())";
        j.update(new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                final PreparedStatement pstmt = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
                pstmt.setString(1, mobile);
                pstmt.setString(2, password);
                return pstmt;
            }
        }, holder);
        return holder.getKey().longValue();

    }

    public boolean mobileExisted(String mobile) {

        String sql = "select count(1) from user where mobile=?";
        int count = j.queryForObject(sql, new Object[]{mobile}, Integer.class);

        return count == 1 ? true : false;

    }

}
