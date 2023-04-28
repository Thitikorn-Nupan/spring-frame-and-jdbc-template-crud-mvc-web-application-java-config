package com.springframe.coding.service.servicemapper;

import com.springframe.coding.entity.User;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;


public class MapperUser implements RowMapper<User> {
    @Override
    public User mapRow(ResultSet resultSet, int i) throws SQLException {
        User user = new User();
        user.setId(resultSet.getLong("id"));
        user.setFullname(resultSet.getString("fullname"));
        user.setAge(resultSet.getShort("age"));
        user.setWeight(resultSet.getFloat("weight"));
        user.setHeight(resultSet.getFloat("height"));
        user.setEmail(resultSet.getString("email"));
        return user;
    }
}
