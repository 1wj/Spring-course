package org.example.ba04.impl;

import org.example.ba02.Student;
import org.example.ba04.SomeService;

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

    @Override
    public String doFirst(String name, Integer age) {
        System.out.println("===目标doFirst===");
        return "helloFirst";
    }

    @Override
    public void doSecond() {
        System.out.println("===目标doSecond===" +10/0);
    }
}
