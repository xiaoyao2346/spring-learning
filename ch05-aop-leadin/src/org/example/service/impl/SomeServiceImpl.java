package org.example.service.impl;

import org.example.service.SomeService;

import java.util.Date;

//service类代码不修改，也能增加输出时间，事务
public class SomeServiceImpl implements SomeService {

    @Override
    public void doSome() {
        //System.out.println("方法的执行时间"+new Date());
        System.out.println("执行业务方法doSome");

        // 方法的最后，提交事务
        //System.out.println("方法执行完毕后，提交事务");
    }

    @Override
    public void doOther() {
        //System.out.println("方法的执行时间"+new Date());
        System.out.println("执行业务方法doOther");
        // 方法的最后，提交事务
        //System.out.println("方法执行完毕后，提交事务");
    }
}
