package org.example;


import org.example.ba02.SomeService;
import org.example.ba02.Student;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyTest02 {
    @Test
    public void test01(){
        String config="applicationContext2.xml";
        ApplicationContext ctx=new ClassPathXmlApplicationContext(config);
        //从容器中获取目标对象
        SomeService proxy=(SomeService)ctx.getBean("someService");
        System.out.println(proxy.getClass().getName());
        //通过代理的对象执行方法，实现  目标方法执行时，增强了功能
        Student str=proxy.doStu("张三", 12);
        System.out.println("str="+str);


    }
}
