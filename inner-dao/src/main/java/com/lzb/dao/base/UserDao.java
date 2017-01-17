package com.lzb.dao.base;

import com.lzb.domain.entity.User;

import java.util.Map;

/**
 * Created by YJC on 2016-10-04.
 */
public interface UserDao extends BaseDao{


    User getUserLogin (Map<String, Object> map) throws Exception;
}
