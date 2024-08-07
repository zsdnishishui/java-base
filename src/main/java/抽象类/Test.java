package 抽象类;

public class Test {
    public static void main(String[] args) {
        Person man = new Man();
        man.run();

        Person women = new Women();
        women.run();
        women.eat();
    }
}
