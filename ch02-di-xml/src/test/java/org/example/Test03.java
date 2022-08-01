package org.example;

import example.ba03.Student;
import example.ba03.School;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test03 {

    @Test
    public void test01(){
        String config = "ba03/applicationContext.xml";
        ApplicationContext context = new ClassPathXmlApplicationContext(config);

        //从容器中获取Student对象
        Student mystudent = (Student) context.getBean("mystudent");
        Student student = (Student) context.getBean("student");
        System.out.println("mystudent对象="+mystudent.hashCode());
        System.out.println("student对象="+student.hashCode());
    }
}
