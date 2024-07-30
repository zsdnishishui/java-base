package 继承.父类型接收子类型;

import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        Son son = new Son();
        son.setName("张三");
        // 父类接收子类
        List<Base> p = new ArrayList<>();
        p.add(son);
        System.out.println(p);
        // 但是父类list不能转子类List，反之也不成立，下面的两种方式可以实现
//        List<Son> sons = p;
        // 方式1
        List<Son> s1 = new ArrayList<>();
        for (Base base : p) {
            Son s = getSon(base); // 强转成功
            s1.add(s);
        }
        System.out.println(s1);
        // 方式2：泛型接收
        List p1 = p;
        List<Son> s2 = p1;
        System.out.println(s2);

        // 那子类能接受父类吗，答案是不能
        List<Son> s3 = new ArrayList<>();
        Base b1 = new Base();
        b1.setId("454242");
        Son s4 = getSon(b1); // 强转失败
        s3.add(s4);
        System.out.println(s3);
    }

    /**
     * 别看用（父类）base接收，你如果真传base却报错
     *
     * @param base
     * @return
     */
    static Son getSon(Base base) {
        Son son = (Son) base; // 强转成功或强转失败
        System.out.println(son);
        return son;
    }
}
