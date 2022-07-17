package jp.nxd;

import jp.nxd.handler.MyInvocationHandle;
import jp.nxd.serive.SomeService;
import jp.nxd.serive.impl.SomeServiceImpl;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class MyTest {
    public static void main(String[] args) {
      /*  SomeService someService=new SomeServiceImpl();
        someService.doSome();
        System.out.println("===================================");
        someService.doOther();*/



        //使用jdk的Proxy创建代理对象
        //创建目标对象
        SomeService target=new SomeServiceImpl();

        //创建InvocationHandler对象
        InvocationHandler handler=new MyInvocationHandle(target);

        //使用Proxy创建代理对象
        SomeService proxy=(SomeService) Proxy.newProxyInstance(
                target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),
                handler);

        //通过代理对象执行方法时，就会调用handler中的invoke()
        proxy.doOther();
        System.out.println("================================");
        proxy.doSome();
    }
}
