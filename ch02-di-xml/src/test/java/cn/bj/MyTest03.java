package cn.bj;

import cn.bj.ba03.Student;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.File;

public class MyTest03 {

    // 一般文件路径是 \ 但在idea中的转义 \\
    //不如用 / 方便  但实际是一样的
    @Test
    public void test01(){
        String config="ba03/applicationContext.xml";
        ApplicationContext ac=new ClassPathXmlApplicationContext(config);
        //从容器中获取文件对象
      Student student=(Student) ac.getBean("mystudent");
        System.out.println(student);
    }
    @Test
    public void test02(){
        String config="ba03/applicationContext.xml";
        ApplicationContext ac=new ClassPathXmlApplicationContext(config);
        //从容器中获取文件对象
        Student student=(Student) ac.getBean("mystudent2");
        System.out.println(student);
    }
    @Test
    public void test03(){
        String config="ba03/applicationContext.xml";
        ApplicationContext ac=new ClassPathXmlApplicationContext(config);
        //从容器中获取文件对象
        Student student=(Student) ac.getBean("mystudent3");
        System.out.println(student);
    }
    @Test
    public void test04(){
     File file=new File("E:\\Spring-course/ch01-hello-spring","readme.txt");
        System.out.println(file.getName());
    }
    @Test
    public void test05(){
        String config="ba03/applicationContext.xml";
        ApplicationContext ac=new ClassPathXmlApplicationContext(config);
        //从容器中获取文件对象
        File student=(File)ac.getBean("myfile");
        System.out.println(student.getName());
    }
}
