package org.example.utils;

import java.util.Date;

public class ServiceTools {
    public static void doLog(){
        System.out.println("非业务方法，方法的执行时间："+new Date());
    }

    public static void doTrans(){
        // 方法的最后，提交事务
        System.out.println("非业务方法，方法执行完毕后，提交事务");
    }
}
