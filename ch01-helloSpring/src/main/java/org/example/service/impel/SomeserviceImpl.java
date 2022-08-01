package org.example.service.impel;

import org.example.service.Someservice;

public class SomeserviceImpl implements Someservice {
    public SomeserviceImpl() {
        System.out.println("SomeserviceImpl的无参构造方法");
    }

    @Override
    public void doSome() {
        System.out.println("执行了SomeServiceImpl的doSome()方法");
    }
}
