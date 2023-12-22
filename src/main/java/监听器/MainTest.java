package 监听器;

public class MainTest {
    public static void main(String[] args) {
        Person person  = new Person();
        person.registerListener(new PersonListener() {
            @Override
            public void eat(Event event) {
                System.out.println(event.getResource() + "正在吃东西");
            }

            @Override
            public void run(Event event) {
                System.out.println(event.getResource() + "跑掉了");
            }
        });
        person.eat();
    }
}
