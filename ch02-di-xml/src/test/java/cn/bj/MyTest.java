package cn.bj;


import cn.bj.ba01.Student;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Date;

public class MyTest {
    @Test
    public void test01(){
        //使用spring容器创建的对象
        //1.指定spring配置文件的名称
        String config="ba01/applicationContext.xml";
        //2.创建表示spring容器的对象，ApplicationContext
        //  ApplicationContext就是表示spring容器，就可以通过容器对象获取对象了
        //ClassPathXmlApplicationContext：表示从类路径中加载spring的配置文件
        ApplicationContext ac=new ClassPathXmlApplicationContext(config);

        //从容器中获取某个对象，你要调用对象的方法
        //getBean（“配置文件中的bean的id值”）
        Student student=(Student) ac.getBean("mystudent");
        Date mydat= (Date) ac.getBean("mydate");
        //使用spring创建好的对象
       System.out.println(student);
        System.out.println(mydat);
    }

}
