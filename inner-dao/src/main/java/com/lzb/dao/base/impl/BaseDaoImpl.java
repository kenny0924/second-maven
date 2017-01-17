package com.lzb.dao.base.impl;

import com.lzb.common.util.AssertUtil;
import com.lzb.dao.base.BaseDao;
import org.apache.ibatis.ognl.ObjectElementsAccessor;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import javax.annotation.Resource;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by YJC on 2016-10-03.
 */

public class BaseDaoImpl<T> extends SqlSessionDaoSupport implements BaseDao {

    private SqlSession session = null;

    @Resource
    public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
        super.setSqlSessionFactory(sqlSessionFactory);
        this.session = this.getSqlSession();
    }

    private Class<T> clazz = null;

    private String statementPrefix = "";

    public BaseDaoImpl() {
        // get method generic paradigm
        Type t = this.getClass().getGenericSuperclass();
        if (t instanceof ParameterizedType) {
            this.clazz = (Class<T>) ((ParameterizedType)t).getActualTypeArguments()[0];
        }
    }

    public T queryForObject(String statement, Object obj) throws Exception {
        return session.selectOne(getFullStatement(statement), obj);
    }

    public T queryForObject(String statement) throws Exception {
        return session.selectOne(getFullStatement(statement));
    }

    public Map<String, Object> queryForMap(String statement, Object object) throws Exception {
        List<Object> rs = session.selectList(getFullStatement(statement), object);
        rs = rs == null ?
                new ArrayList<Object>() : rs;
        AssertUtil.listGtLength(rs, 1, "the result have mutiple value");
        return null;
    }

    public List<?> queryForList (String statement) throws Exception{
        return session.selectList(getFullStatement(statement));
    }

    public List<?> queryForList(String statement, Object obj) throws Exception{
        return session.selectList(getFullStatement(statement), obj);
    }

    public String getStatementPrefix() {
        return statementPrefix;
    }

    public void setStatementPrefix(String statementPrefix) {
        this.statementPrefix = statementPrefix;
    }

    private String getFullStatement(String statement) {
        return getStatementPrefix() + "." + statement;
    }
}
