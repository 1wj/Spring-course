package nj.nxd;

import nj.nxd.ba01.Student;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyTest {
    @Test
    public void test01(){
        String config= "ba01/applicationContext.xml";
        ApplicationContext cxt=new ClassPathXmlApplicationContext(config);
        Student student= (Student) cxt.getBean("myStudent");
        System.out.println("student==="+student);
    }
}
