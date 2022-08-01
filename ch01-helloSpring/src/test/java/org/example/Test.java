package org.example;

import org.example.service.Someservice;
import org.example.service.impel.SomeserviceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Date;

public class Test {
    @org.junit.Test
    public void test01(){
        Someservice service  = new SomeserviceImpl();
        service.doSome();
    }
    /*
    * spring默认创建对象的时间：在创建spring的容器时，会创建配置文件中的所有对象
    * spring创建对象，默认调用的是无参构造方法
    * */
    @org.junit.Test
    public void test02(){
        //使用spring容器创建的对象
        //1.指定spring配置文件的名称
        String config = "beans.xml";
        //2.创建表示spring容器的对象，ApplicationContex
        //ApplicationContext就表示spring容器，通过这个容器获取对象
        //ClassPathXmlApplicationContext：表示从类路径中加载spring的配置文件
        ApplicationContext context = new ClassPathXmlApplicationContext(config);

        //从容器中获取某个对象
        //getBean(配置文件中bean的id值)
        Someservice someservice = (Someservice) context.getBean("someservice");
        System.out.println(someservice.hashCode());

        //使用spring创建好的对象
        someservice.doSome();
    }
    /*
    * 获取spring容器中java对象的信息
    * */
    @org.junit.Test
    public void test3(){
        String config = "beans.xml";
        ApplicationContext context = new ClassPathXmlApplicationContext(config);
        //使用spring提供的方法，获取容器中定义对象的数量
        int nums = context.getBeanDefinitionCount();
        System.out.println("容器中定义的对象数量："+nums);
        //容器中每个定义的对象的名称
        String[] names = context.getBeanDefinitionNames();
        for(String name:names){
            System.out.println(name);
        }
    }
    //获取一个非自定义的类对象
    @org.junit.Test
    public void test4(){
        String config = "beans.xml";
        ApplicationContext context = new ClassPathXmlApplicationContext(config);
        //使用getBean();
        Date mydate = (Date) context.getBean("mydate");
        System.out.println("Date:"+mydate);
    }
}
