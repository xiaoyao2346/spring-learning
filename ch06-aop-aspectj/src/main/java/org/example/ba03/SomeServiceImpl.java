package org.example.ba03;

// 目标类
public class SomeServiceImpl implements SomeService {
    @Override
    public void doSome(String name,Integer age){
        // 给doSome方法增加一个功能，在doSome()执行之前，输出方法的执行时间
        System.out.println("====目标方法doSome()====");
    }

    @Override
    public String doOther(String name, Integer age) {
        System.out.println("====目标方法doSome()====");
        return "dfasdf";
    }

    @Override
    public String doFirst(String name, Integer age) {
        System.out.println("====业务方法doFirst()====");
        return "doFirst()";
    }
}
