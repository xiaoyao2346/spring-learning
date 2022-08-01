package example.ba01;

public class Student {
    private String name;
    private int age;

    public Student(){
        System.out.println("spring调用无参构造函数创建对象");
    }

    public void setName(String name) {
        System.out.println("调用setName:"+name);
        this.name = name;
    }

    public void setAge(int age) {
        System.out.println("调用setAge:"+age);
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
