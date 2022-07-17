package com.bjpowernode.service.impl;

import com.bjpowernode.dao.UserDao;
import com.bjpowernode.dao.impl.UserDaoImpl;
import com.bjpowernode.domain.SysUser;
import com.bjpowernode.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("myUserService")
public class UserServiceImpl implements UserService {

//@Autowired()
//@Qualifier("myOracleDao")
    @Resource(name="myOracleDao")
    private UserDao dao = null;

    public UserServiceImpl(){

    }

    public  UserServiceImpl(UserDao dao){
        this.dao=dao;
    }
    public void setDao(UserDao dao) {
        this.dao = dao;
    }

    @Override
    public void addUser(SysUser user) {
        //处理数据，调用dao的方法
        //调用dao的方法
        dao.insertUser(user);
    }
}
