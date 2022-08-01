package org.example.ba07.ba06;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

// 省略value
@Component("mystudent")
public class Student {

    /*
    *   @Value：简单类型的属性赋值
    *     属性：value是String类型的，表示简单类型的属性值
    *     位置：1.在属性上面，无需set方法，推荐使用
    *          2.在set方法的上面
    *
    *   如果要使用byName方式，需要做的是：
    *    1.在属性上面加入@Autowired
    *    2.在属性上面@Qualifier(value = "bean的id)：表示使用指定名称的bean完成赋值
    *
    * */
    @Value(value = "张飞")
    private String name;
    @Value(value = "29")
    private Integer age;

    /**
     *  引用类型
     * @Resource：来自JDK中的注解，spring框架提供了对这个注解的功能支持，可以使用它给引用类型赋值
     *      使用的也是自动注入原理，支持byName，byType，默认是byName
     *   位置：1.在属性定义的上面，无需set方法，推荐使用
     *        2.在set方法的上面
     *
     * @Resource只使用byName方式，需要增加一个属性 name，
     * name的属性值是bean的id（名称）
     * */
    //只使用byName
    @Resource(name = "myschool")
    private School school;

    public Student(){
        System.out.println("==Student无参构造方法===");
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", school=" + school +
                '}';
    }
}
