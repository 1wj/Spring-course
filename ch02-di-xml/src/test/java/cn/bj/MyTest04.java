package cn.bj;

import cn.bj.ba04.Student;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.File;

public class MyTest04 {

    @Test
    public void test01(){
        String config="ba04/applicationContext.xml";
        ApplicationContext ac=new ClassPathXmlApplicationContext(config);
        //从容器中获取文件对象
      Student student=(Student) ac.getBean("mystudent");
        System.out.println(student);
    }
}
