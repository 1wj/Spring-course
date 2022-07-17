package nj.nxd;

import nj.nxd.ba07.Student;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyTest07 {
    @Test
    public void test01(){
        String config= "ba07/applicationContext.xml";
        ApplicationContext cxt=new ClassPathXmlApplicationContext(config);
        Student student= (Student) cxt.getBean("myStudent");
        System.out.println("student==="+student);
    }
}
