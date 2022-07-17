package org.example.ba06;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

/**
 * @Aspect : 是aspectj框架中的注解
 *   作用：表示当前类是切面类
 *   切面类：是用来给业务方法增加功能的类，在这个类中有切面的功能代码
 *   位置：在类的定义的上面
 *
 */

/**
 * @Pointcut :（起辅助作用的）定义和管理切入点，如果你的项目中有多个切入点表达式是重复的，
 *            可以复用的 可以使用Pointcut
 *    属性：value 切入点表达式
 *    位置：在自定义的方法上面
 *    特点：当使用@Pointcut定义在一个方法的上面，此时这个方法的名称就是切入点表达式的别名 。
 *         其他的通知中，value属性就可以使用这个方法名称，代替切入点表达式
 */
@Aspect
public class MyAspect {

    // 这个方法一般是不需要被外部调用的就可以使用private
    @Pointcut(value = "execution(* *..SomeServiceImpl.doThird(..))")
    private void eee(){
        //内部无须代码 只是为了别名
    }
    @After(value = "eee()")
    public void myAfter(){
        System.out.println("最终通知 一定会被执行哪怕报异常");
        //一般做资源清除工作的
    }
    @Before(value="eee()")
    public void muBefore(){
        System.out.println("前置通知，在目标方法之前执行");
    }




}







