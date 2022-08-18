package org.example.ba01;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

import java.util.Date;

/**
 * @Aspect：是aspect框架中的注解。
 *      作用：表示当前类是切面类
 *      切面类：是用来给业务方法增加功能的类，在这个类中有切面的功能代码
 *      位置：在类定义的上面
 * */

@Aspect
public class MyAspect {
    /**
     * 定义方法，方法是实现切面功能的。
     * 方法的定义要求：
     * 1.公共方法 public
     * 2.方法没有返回值
     * 3.方法名称自定义
     * 4.方法可以有参数，也可以没有参数
     *   如果有参数，参数不是自定义的，有几个参数类型可以使用
     * */

    /**
     * @Before：前置通知注解
     *     属性：value，是切入点表达式，表示切面的功能执行的位置
     *     位置：在方法的上面
     * 特点：
     *   1.在目标方法之前先执行的
     *   2.不会改变目标方法的执行结果
     *   3.不会影响目标方法的执行。
     */

    /**
     * 指定通知方法中的参数：joinpoint
     * jointpoint：业务方法，要加入切面功能的业务方法
     *    作用是：可以在通知方法中获取方法执行时的信息，例如方法名称，方法的实参。
     *    如果你的切面功能中需要用到方法的信息，就加入joinpoint。
     *    这个joinpoint参数的值是由框架赋予，必须是第一个位置的参数
     */
    @Before(value = "execution(public void org.example.ba01.SomeService.doSome(String,Integer))")
    //@After(value = "execution(public void org.example.ba01.SomeService.doSome(String,Integer))")
    public void myBefore(JoinPoint jp){
        // 获取方法的完整定义
        System.out.println("方法的签名（定义）="+jp.getSignature());
        System.out.println("方法的名称="+jp.getSignature().getName());
        // 获取方法的实参
        Object args[] = jp.getArgs();
        for (Object arg : args){
            System.out.println("参数="+arg);
        }
        // 就是切面要执行的功能代码
        System.out.println("前置通知，切面功能：在目标方法之前输出执行时间："+new Date());
    }

}
