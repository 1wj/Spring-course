package org.example.ba05.impl;

import org.example.ba02.Student;
import org.example.ba05.SomeService;

//目标类
public class SomeServiceImpl  implements SomeService {

    @Override
    public void doThird() {
        System.out.println("===执行doThird()==="+10/0);
    }
}
