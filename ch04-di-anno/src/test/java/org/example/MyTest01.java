package org.example;

import org.example.ba01.Student;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyTest01 {

    @Test
    public void test01(){
        String config = "applicationContext.xml";
        ApplicationContext context = new ClassPathXmlApplicationContext(config);
        // 从容器中获取对象
        Student student = (Student) context.getBean("mystudent");
        System.out.println("student="+student);
    }
}
