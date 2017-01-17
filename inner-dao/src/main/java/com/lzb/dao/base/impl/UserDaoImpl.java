package com.lzb.dao.base.impl;

import com.lzb.dao.base.UserDao;
import com.lzb.domain.entity.User;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by YJC on 2016-10-04.
 */

public class UserDaoImpl extends BaseDaoImpl<User> implements UserDao{

    private static String STATEMENT = "UserMapper";

    public UserDaoImpl () {
        this.setStatementPrefix(STATEMENT);
    }

    public User getUserLogin (String username, String password) throws Exception {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("username", username);
        map.put("password", password);

        return this.queryForObject("getLoginUser", map);
    }

    public User getUserLogin(Map<String, Object> map) throws Exception {
        return null;
    }
}
