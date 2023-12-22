package 泛型;

import enity.Student;
import 继承.A;
import 继承.B;

public class Test {

    public static <T> void canShu(T t) {
        if (t instanceof Student) {
            System.out.println(((Student) t).getId());
        }
    }
    public static void canShu2(Object t) {
        if (t instanceof Student) {
            System.out.println(((Student) t).getId());
        }
    }
    public static void canShu3(A t) {
        if (t instanceof B){
            System.out.println(t.getId());
        }
    }
}
