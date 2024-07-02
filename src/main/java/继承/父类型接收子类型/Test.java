package 继承.父类型接收子类型;

import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        Son son = new Son();
        son.setName("张三");
        getSon(son);
        // 父类接收子类
        List<Base> p = new ArrayList<>();
        p.add(son);
    }

    static void getSon(Base base) {
        Son son = (Son) base;
        System.out.println(son);
    }
}
