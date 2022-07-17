package jp.nxd.util;

import java.util.Date;
//service类不修改也能够增加输出时间 事务
public class ServiceTools {
    public static void doLog(){
        System.out.println("非业务方法，方法执行时间："+new Date());
    }
    public static void doTrans(){
        //方法的最后，提交事务
        System.out.println("方法执行完毕后，提交事务");
    }
}
