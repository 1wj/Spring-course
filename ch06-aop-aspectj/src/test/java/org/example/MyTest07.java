package org.example;


import org.example.ba07.SomeServiceImpl;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyTest07 {
    @Test
    public void test01(){
        String config="applicationContext7.xml";
        ApplicationContext ctx=new ClassPathXmlApplicationContext(config);
        SomeServiceImpl proxy=(SomeServiceImpl) ctx.getBean("someService");

        //如果目标类是有接口的 aop默认使用的是jdk的动态代理
        //若果目标类没有接口， aop默认使用的是cglib
        System.out.println("proxy=="+proxy.getClass().getName());

        proxy.doThird();



    }
}
