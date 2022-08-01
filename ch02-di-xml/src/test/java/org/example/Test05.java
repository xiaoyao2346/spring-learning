package org.example;

import example.ba05.Student;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test05 {

    @Test
    public void test01(){
        String config = "ba05/applicationContext.xml";
        ApplicationContext context = new ClassPathXmlApplicationContext(config);

        //从容器中获取Student对象
        Student mystudent = (Student) context.getBean("mystudent");
        System.out.println("student对象="+mystudent);
    }
}
