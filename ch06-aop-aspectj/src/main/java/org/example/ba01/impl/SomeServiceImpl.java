package org.example.ba01.impl;

import org.example.ba01.SomeService;

//目标类
public class SomeServiceImpl  implements SomeService {
    @Override
    public void doSome(String name, Integer age) {
        //给doSome方法增加一个功能，在doSome（）执行之前，输出方法的执行时间
        System.out.println("====目标doSome（）====");
    }

    @Override
    public void Other(String name, Integer age) {
        System.out.println("====目标doOther()====");
    }
}
