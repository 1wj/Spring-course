package cn.bj;

import cn.bj.service.SomeService;
import cn.bj.service.impl.SomeServiceImpl;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Date;

public class MyTest {

    @Test
    public void test01(){
        SomeService someService=new SomeServiceImpl();
        someService.doSome();
    }

    /**
     * spring默认创建对象的时间：在创建spring的容器时，会创建配置文件中的所有的对象
     * spring创建对象默认调用的是无参数构造方法
     */
    @Test
    public void test02(){
        //使用spring容器创建的对象
        //1.指定spring配置文件的名称
        String config="beans.xml";
        //2.创建表示spring容器的对象，ApplicationContext
        //  ApplicationContext就是表示spring容器，就可以通过容器对象获取对象了
        //ClassPathXmlApplicationContext：表示从类路径中加载spring的配置文件
        ApplicationContext ac=new ClassPathXmlApplicationContext(config);

        //从容器中获取某个对象，你要调用对象的方法
        //getBean（“配置文件中的bean的id值”）
        SomeService service =(SomeService) ac.getBean("someService");



        //使用spring创建好的对象
        service.doSome();


    }
    @Test
    public void test03(){
        String config="beans.xml";
        ApplicationContext ac=new ClassPathXmlApplicationContext(config);
        int  nums  = ac.getBeanDefinitionCount();
        System.out.println("容器中中定义的对象数量："+nums);
        String names[] =ac.getBeanDefinitionNames();
        for (String name:names) {
            System.out.println(name);
        }
    }

    @Test
    public void test04(){
        String config="beans.xml";
        ApplicationContext  ac=new ClassPathXmlApplicationContext(config);
        Date mydate = (Date)ac.getBean("mydate");
        System.out.println(mydate);
    }
}
