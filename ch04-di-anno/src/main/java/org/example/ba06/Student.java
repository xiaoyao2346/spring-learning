package org.example.ba06;

import org.example.myannotation.Xiao;
import org.example.myannotation.XiaoHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

// 省略value
@Component("mystudent")
public class Student {

    /**
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
    @Xiao(value = "张三")
    public String name;

    private Integer age;

    /**
     *  引用类型
     * @Resource：来自JDK中的注解，spring框架提供了对这个注解的功能支持，可以使用它给引用类型赋值
     *      使用的也是自动注入原理，支持byName，byType，默认是byName
     *   位置：1.在属性定义的上面，无需set方法，推荐使用
     *        2.在set方法的上面
     * */
    //默认是byName自动注入：先使用byName自动注入，如果byName赋值失败，再使用byType
    @Autowired
    private School school;

    public Student(){
        System.out.println("==Student无参构造方法===");
        XiaoHandler.xiaohandler(this);
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
