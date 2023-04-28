package com.springframe.coding.service;

import com.springframe.coding.entity.User;
import com.springframe.coding.repository.UserRepository;
import com.springframe.coding.service.servicedirectsql.SqlDirect;
import com.springframe.coding.service.servicemapper.MapperUser;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserService implements UserRepository<User> {
    final private JdbcTemplate jdbcTemplate;
    private SqlDirect sqlDirect;

    public UserService (DriverManagerDataSource getDriverManagerDataSource) {
        jdbcTemplate = new JdbcTemplate(getDriverManagerDataSource);
        sqlDirect = new SqlDirect();
    }

    @Override
    public List<User> views() {
        MapperUser mapperUser = new MapperUser();
        List<User> userList = jdbcTemplate.query(sqlDirect.getREADS(), mapperUser );
        return userList;
    }

    @Override
    public User view(Long id) {
        Object[]arg = {id};
        MapperUser mapperUser = new MapperUser();
        User userSearch = jdbcTemplate.queryForObject(sqlDirect.getREAD(),arg,mapperUser);
        if (userSearch != null){
            return userSearch;
        }
        else {
            return new User(); /* any attribute is null that is good to check something */
        }
    }

    @Override
    public Map<?, User> create(User objects) {
        Map<String,User> response = new HashMap<>();
        int rows = jdbcTemplate.update(sqlDirect.getCREATE(),objects.getFullname(),objects.getEmail(),objects.getAge(),objects.getWeight(),objects.getHeight());
        if (rows > 0) {
            response.put("create successfully",objects);
        }
        else {
            response.put("create failed",new User());
        }
        return response;
    }

    @Override
    public Map<?, User> update(User objects) {
        Map<String,User> response = new HashMap<>();
        jdbcTemplate.update(sqlDirect.getUPDATE(),objects.getFullname(),objects.getEmail(),objects.getAge(),objects.getWeight(),objects.getHeight(),objects.getId());
        response.put("update successfully",objects);
        return response;
    }
    @Override
    public Map<?,User> delete(Long id) {
        Map<String,User> response = new HashMap<>();
        response.put("delete order "+id+" successfully",view(id));
        jdbcTemplate.update(sqlDirect.getDELETE(),id);
        return response;
    }

}
