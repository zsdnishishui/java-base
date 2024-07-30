package 多态;

public class Test {
    public static void main(String[] args) {
//        show(new Cat());  // 以 Cat 对象调用 show 方法
//        show(new Dog());  // 以 Dog 对象调用 show 方法

        Animal a = new Animal();  // 向上转型
        a.eat();               // 调用的是 Cat 的 eat
        Cat c = (Cat) a;        // 向下转型,在工程中很少用到，要想向下转型成功，必须A是A,说白了java不存在向下转型
        c.work();        // 调用的是 Cat 的 work

//        Animal b = new Animal(); // 抽象类不能new
    }

    public static void show(Animal a) {
        a.eat();
        // 类型判断
        if (a instanceof Cat) {  // 猫做的事情
            Cat c = (Cat) a;
            c.work();
        } else if (a instanceof Dog) { // 狗做的事情
            Dog c = (Dog) a;
            c.work();
        }
    }
}

class Animal {
    void eat() {
        System.out.println("animal");
    }
}

class Cat extends Animal {
    @Override
    public void eat() {
        System.out.println("吃鱼");
    }

    public void work() {
        System.out.println("抓老鼠");
    }
}

class Dog extends Animal {
    @Override
    public void eat() {
        System.out.println("吃骨头");
    }

    public void work() {
        System.out.println("看家");
    }
}
