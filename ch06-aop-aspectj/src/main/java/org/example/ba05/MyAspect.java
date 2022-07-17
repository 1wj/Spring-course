package org.example.ba05;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;

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
     * 最终通知定义方法，方法是实现切面功能的。
     * 方法的定义要素：
     *  1.公共方法 public
     *  2.无返回值
     *  3.方法名称自定义
     *  4.方法无参数，如果还有是JoinPoint
     */
    /**
     * @After: 最终通知
     *   属性：value 切入点表达式
     *   位置：方法上面
     *  特点：
     *   1.总是会被执行
     *   2.在目标方法之后执行的
     *
     * try{
     *     SomeServiceImpl.doThird(..)
     * }catch（Execption e）{
     *
     * }finall{
     *     myAfter()
     * }
     *
     */
    @After(value = "execution(* *..SomeServiceImpl.doThird(..))")
    public void myAfter(){
        System.out.println("最终通知 一定会被执行哪怕报异常");
        //一般做资源清除工作的
    }

}







