package jp.nxd.handler;

import jp.nxd.util.ServiceTools;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class MyInvocationHandle implements InvocationHandler {
    //目标对象
    private Object target;//这个目标对象最终是someserviceimpl类

    public MyInvocationHandle(Object target) {
        this.target = target;
    }


    //什么时候执行：通过代理对象执行方法时，会调用这个invoke方法
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {



        Object res=null;
        System.out.println("执行了MyInvocationHandler的invoke（）");

        String methodName=method.getName();
        System.out.println("method名"+method.getName());

        if("doSome".equals(methodName)){
            ServiceTools.doLog();  //在目标方法执行之前 日志
            //执行目标类的方法，通过Method类实现
            res=method.invoke(target,args);//SomeServiceImpl.doSome()
            ServiceTools.doTrans();//在目标方法执行之后 事务
        }else {
            res=method.invoke(target,args);//SomeServiceImpl.doOther()
        }



       //返回目标方法的执行结果
        return res;


    }
}
