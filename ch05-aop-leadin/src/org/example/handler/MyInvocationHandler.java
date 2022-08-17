package org.example.handler;

import org.example.utils.ServiceTools;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class MyInvocationHandler implements InvocationHandler {
    // 目标对象
    private Object target;

    public MyInvocationHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        // 通过代理对象执行方法时，会调用执行这个invoke()
        System.out.println("执行MyInvocationHandler中的invoke()方法");
        System.out.println("method名称："+method.getName());
        Object res = null;
        ServiceTools.doLog();
        //执行目标类的方法，通过Method类实现
        res = method.invoke(target,args);//SomeServiceImpl.doSome(),doOther()
        ServiceTools.doTrans();
        //目标方法的执行结果
        return res;
    }
}
