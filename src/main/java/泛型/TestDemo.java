package 泛型;

import enity.Student;
import 继承.B;

import java.util.Arrays;

public class TestDemo {
    public static void main(String[] args) {

        B b = new B();
        b.setId("2121");
        Test.canShu3(b);
        Student student = new Student();
        student.setId("212121");
        Test.canShu(student);

        Student student2 = new Student();
        student2.setId("000");
        Test.canShu2(student2);

        Pair<Integer> p = new Pair<>(123, 456);
        int n = add(p);
        System.out.println(n);

        add2(student);

        String[] arr = asArray("one", "two", "three");
        System.out.println(Arrays.toString(arr));
        // ClassCastException:
        String[] firstTwo = pickTwo("one", "two", "three");
        System.out.println(Arrays.toString(firstTwo));
    }

    static int add(Pair<? extends Number> p) {
        Number first = p.getFirst();
        Number last = p.getLast();
        return first.intValue() + last.intValue();
    }

    static <T> void add2(T t) {
        if (t instanceof Student){
            System.out.println(((Student) t).getId());
        }
    }
    static <K> K[] pickTwo(K k1, K k2, K k3) {
        return asArray(k1, k2);
    }

    static <T> T[] asArray(T... objs) {
        return objs;
    }
}
