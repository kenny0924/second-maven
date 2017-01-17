package com.lzb.service;

import com.lzb.domain.entity.User;
import org.springframework.stereotype.Service;

/**
 * Created by YJC on 2016-10-03.
 */
public interface UserService {

    /**
     * 根据账号和密码获取用户信息
     * @param username
     * @param password
     * @return
     * @throws Exception
     */
    User getUserLogin(String username, String password) throws Exception;

}
