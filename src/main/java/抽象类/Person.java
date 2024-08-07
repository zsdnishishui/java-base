package 抽象类;

public abstract class Person {

    public String id;

    abstract void run();

    public void eat() {
        System.out.println("person eat");
    }
}
