package 注解;

public class PersonTest {
    @PersonAnnotation(name = "张三", age = 20)
    public void method_1() {
    }

    @PersonAnnotation(name = "李四", age = 21)
    public void method_2() {
    }
}
