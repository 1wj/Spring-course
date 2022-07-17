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
        buyGoodsService.buy(1,10);
       //buyGoodsService.buy(1,500);
    }
}
