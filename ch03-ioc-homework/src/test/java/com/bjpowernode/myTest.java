package com.bjpowernode;

import com.bjpowernode.domain.SysUser;
import com.bjpowernode.service.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class myTest {
    @Test
    public void test01(){
        String config="applicationContext.xml";
        ApplicationContext ac=new ClassPathXmlApplicationContext(config);
        UserService userService = (UserService) ac.getBean("myUserService");
        SysUser sysUser=new SysUser();
        sysUser.setAge(16);
        sysUser.setName("张三");
        userService.addUser(sysUser);
    }
}
