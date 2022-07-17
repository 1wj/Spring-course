package org.example.ba02.impl;

import org.example.ba02.SomeService;
import org.example.ba02.Student;

//目标类
public class SomeServiceImpl  implements SomeService {
    @Override
    public void doSome(String name, Integer age) {
        //给doSome方法增加一个功能，在doSome（）执行之前，输出方法的执行时间
        System.out.println("====目标doSome（）====");
    }

    @Override
    public String doOther(String name, Integer age) {
        System.out.println("====目标doOther()====");
        return "abcd";
    }

    @Override
    public Student doStu(String name, Integer age) {
        Student student=new Student(name,age);
        return student;
    }
}
