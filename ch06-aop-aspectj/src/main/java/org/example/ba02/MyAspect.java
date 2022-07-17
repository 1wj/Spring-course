package org.example.ba02;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

import java.util.Date;

/**
 * @Aspect : 是aspectj框架中的注解
 *   作用：表示当前类是切面类
 *   切面类：是用来给业务方法增加功能的类，在这个类中有切面的功能代码
 *   位置：在类的定义的上面
 *
 */
@Aspect
public class MyAspect {
    /**
     * 后置通知定义方法，方法是实现切面功能的。
     * 方法的定义要素：
     *  1.公共方法 public
     *  2.方法没有返回值
     *  3.方法名称自定义
     *  4.方法有参数，推荐使用Object ，参数名自定义
     */

    /**
     *  属性：1.value：切入点表达式
     *       2.returning 自定义的变量，表示目标方法的返回值。
     *         自定义的变量必须和通知方法的形参名一样
     *  位置：在方法定义的上面
     *  特点：
     *      1.在目标方法之后执行的。
     *      2.能后获取到目标方法的返回值 可以根据这个返回值做不同的处理功能 (传值)
     *         Object res=doOther();
     *      3.可以修改这个返回值
     *后置通知的执行
     *     1.Object res=doOther（）； 先执行目标方法
     *       参数传递：传值，传引用
     *     2.myAfterReturning(res);  再执行后置通知
     *
     *
     */
    @AfterReturning(value = "execution(* *..SomeServiceImpl.doOther(..))" ,returning="res")
   public void myAfterReturning(JoinPoint jp,Object res){
        //Object res:是目标方法执行之后的返回值，然后可以根据返回值做你的切面的功能处理
        System.out.println("1=====后置通知：在目标方法之后执行的，获取的返回值是："+res);
        System.out.println("方法的签名="+jp.getSignature());
        if(res.equals("abcd")){
            //做一些功能
        }else {
            //做另外一些功能
        }
        //修改目标方法的返回值，看一下是否会影响 最后的（业务）方法调用结果
        if(res!=null){
            res="hello";
        }
   }
   //课后作业  由于String是不变的所以试试  修改传入的Student对象看方法返回值是否会变
   @AfterReturning(value = "execution(* *..SomeServiceImpl.doStu(..))" ,returning = "res")
   public void myAfterReturning2(JoinPoint jp,Object res){
       System.out.println("2=====后置通知：在目标方法之后执行的，获取的返回值是："+res);
       System.out.println("方法的签名="+jp.getSignature());
        Student stu=new Student("chendi",21);
        res=stu;
       System.out.println("stu="+stu);
   }
}



