package org.example;


import org.example.ba08.SomeService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyTest08 {
    @Test
    public void test01(){
        String config="applicationContext8.xml";
        ApplicationContext ctx=new ClassPathXmlApplicationContext(config);

        //若目标类有接口必须转成接口
        SomeService proxy=(SomeService) ctx.getBean("someService");

        //如果目标类是有接口的 aop默认使用的是jdk的动态代理
        //若果目标类没有接口， aop默认使用的是cglib
        //但有接口也可以改成使用cglib接口
        System.out.println("proxy=="+proxy.getClass().getName());

        proxy.doThird();



    }
}
