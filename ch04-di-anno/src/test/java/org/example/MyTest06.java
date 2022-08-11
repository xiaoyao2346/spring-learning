package org.example;

import org.example.ba06.School;
import org.example.ba06.Student;
import org.example.myannotation.Xiao;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.lang.reflect.Method;

public class MyTest06 {

    @Test
    public void test01(){

        School school = new School();
        System.out.println("school="+school);

        String config = "applicationContext.xml";
        ApplicationContext context = new ClassPathXmlApplicationContext(config);
        // 从容器中获取对象
        Student student = new Student();//(Student) context.getBean("mystudent");
        System.out.println("student="+student);
        Class cl = student.getClass();
        System.out.println(cl.hashCode());

        try{

            Student student1 = (Student) cl.newInstance();
            System.out.println("student1="+student1);
            System.out.println(cl.getField("name"));
            Method m1 = cl.getMethod("setName", String.class);
            System.out.println(m1);
            m1.invoke(student,"李四");
            System.out.println("student="+student);
        }catch (Exception e){System.out.println(e);}

    }
}
