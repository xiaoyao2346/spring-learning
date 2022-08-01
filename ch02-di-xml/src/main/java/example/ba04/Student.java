package example.ba04;

public class Student {
    private String name;
    private int age;

    //声明一个引用类型
    private School school;

    public Student(){
        System.out.println("spring调用无参构造函数创建对象");
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setSchool(School school) {
        this.school = school;
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
