package org.example;

import org.example.service.BuyGoodsService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyTest {
    @Test
    public  void test01(){
        String confit="applicationContext.xml";
        ApplicationContext act=new ClassPathXmlApplicationContext(confit);
        BuyGoodsService buyGoodsService = (BuyGoodsService) act.getBean("buyGoodsService");
        System.out.println("service的代理：："+buyGoodsService.getClass().getName());
        buyGoodsService.buy(2,1);

    }
}
