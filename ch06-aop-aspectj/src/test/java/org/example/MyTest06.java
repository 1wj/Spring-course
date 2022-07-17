package org.example;


import org.example.ba06.SomeService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyTest06 {
    @Test
    public void test01(){
        String config="applicationContext6.xml";
        ApplicationContext ctx=new ClassPathXmlApplicationContext(config);
        //从容器中获取目标对象
        SomeService proxy=(SomeService)ctx.getBean("someService");
        System.out.println(proxy.getClass().getName());
        //通过代理的对象执行方法，实现  目标方法执行时，增强了功能
        proxy.doThird();



    }
}
