package org.example;

import org.example.handler.MyInvocationHandler;
import org.example.service.SomeService;
import org.example.service.impl.SomeServiceImpl;
import org.example.service.impl.SomeServiceImpl2;
import org.example.utils.ServiceTools;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class MyApp {
    public static void main(String[] args){
        //调用doSome，doOther
//        SomeService service = new SomeServiceImpl2();
//        service.doSome();
//        System.out.println("=================================");
//        service.doOther();

        // 使用jdk的Proxy创建代理对象
        // 创建目标对象
        SomeService target = new SomeServiceImpl();


        // 创建InvocationHandler对象
        InvocationHandler handler = new MyInvocationHandler(target);

        // 使用Proxy创建代理
        SomeService proxy = (SomeService) Proxy.newProxyInstance(
                target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),handler);

        SomeService proxy01 = (SomeService) Proxy.newProxyInstance(
                target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),((proxy1, method, args1) -> {
                    System.out.println("执行MyInvocationHandler中的invoke()方法");
                    Object res = null;
                    ServiceTools.doLog();
                    //执行目标类的方法，通过Method类实现
                    res = method.invoke(target,args1);//SomeServiceImpl.doSome(),doOther()
                    ServiceTools.doTrans();
                    //目标方法的执行结果
                    return res;
                }));

        SomeService proxy02 = (SomeService) Proxy.newProxyInstance(
                target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),handler::invoke);

        // 通过代理执行方法，会调用handler中的invoke()
        proxy.doOther();
        System.out.println("===================================");
        proxy01.doSome();
    }
}
