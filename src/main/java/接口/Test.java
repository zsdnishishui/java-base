package 接口;

public class Test {
    public static void main(String[] args) {
        Base base = new Person();
        eat(base);
        Base base2 = new Animal();
        eat(base2);
    }

    static void eat(Base base) {
        base.eat();
    }
}
