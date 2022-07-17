package cn.bj;

import cn.bj.ba02.School;
import cn.bj.ba02.Student;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyTest02 {
    @Test
    public void test01(){
        String config="ba02/applicationContext.xml";
        ApplicationContext ac=new ClassPathXmlApplicationContext(config);
        Student mystudent = (Student) ac.getBean("mystudent");
        System.out.println(mystudent);
    }
}
