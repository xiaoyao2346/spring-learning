package org.example;


import example.ba01.Student;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Date;

public class Test {

    @org.junit.Test
    public void test01(){
        String config = "ba01/applicationContext.xml";
        ApplicationContext context = new ClassPathXmlApplicationContext(config);

        //从容器中获取Student对象
        Student mystudent = (Student) context.getBean("mystudent");
        System.out.println("student对象="+mystudent);
    }

}
