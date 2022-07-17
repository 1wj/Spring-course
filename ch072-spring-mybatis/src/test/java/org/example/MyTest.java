package org.example;


import org.example.dao.StudentDao;
import org.example.domain.Student;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class MyTest {
   //@Test
    public void test01(){
        String config="applicationContext.xml";
        ApplicationContext act=new ClassPathXmlApplicationContext(config);
         String [] names=act.getBeanDefinitionNames();
        for (String na : names) {
            System.out.println("容器中的对象名："+na+"===="+act.getBean(na).getClass().getName());
            //容器中的对象名：myDataSource====com.alibaba.druid.pool.DruidDataSource
            //容器中的对象名：SqlsessionFatctory====org.apache.ibatis.session.defaults
        }
    }

   @Test
    public void test02(){
        String config="applicationContext.xml";
        ApplicationContext act=new ClassPathXmlApplicationContext(config);
       StudentDao studentDao= (StudentDao) act.getBean("studentDao");
    List<Student> students = studentDao.selectStudents();
       students.forEach(stu-> System.out.println("stu===="+stu));
       // Student student=new Student(1023,"陈风1","ch@qq.com",23);
        //int i = studentDao.insertStudent(student);
        //System.out.println(i);
    }
}
