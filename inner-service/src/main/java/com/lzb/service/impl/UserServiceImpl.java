package com.lzb.service.impl;

import com.lzb.dao.base.UserDao;
import com.lzb.domain.entity.User;
import com.lzb.service.UserService;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by YJC on 2016-10-03.
 */
@Service("userService")
public class UserServiceImpl implements UserService {

    public UserServiceImpl () {
        System.out.print("init user service");
    }

    @Autowired
    private UserDao userDao;

    public User getUserLogin(String username, String password) throws Exception {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("username", username);
        map.put("password", password);
        return userDao.getUserLogin(map);
    }
}
