package cn.bj;

import cn.bj.ba06.Student;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyTest06 {

    @Test
    public void test01(){
        //加载的是总的文件
        String config= "ba06/total.xml";
        ApplicationContext ac=new ClassPathXmlApplicationContext(config);
        //从容器中获取文件对象
      Student student=(Student) ac.getBean("mystudent");
        System.out.println(student);
    }
}
