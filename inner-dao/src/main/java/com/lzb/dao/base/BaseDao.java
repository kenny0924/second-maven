package com.lzb.dao.base;

import java.security.PrivateKey;
import java.util.List;
import java.util.Map;

/**
 * Created by YJC on 2016-10-03.
 */
public interface BaseDao<T> {

    T queryForObject(String statement, Object obj)throws Exception;

    T queryForObject(String statement) throws Exception;

    Map<String, Object> queryForMap(String statement, Object object) throws Exception;

    List<?> queryForList (String statement) throws Exception;

    List<?> queryForList(String statement, Object obj) throws Exception;
}
