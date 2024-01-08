package 反射;

import enity.Student;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class Test {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Class<?> clazz = Student.class;
        System.out.println(clazz.getName()); // enity.Student
        System.out.println(clazz.getSimpleName()); // Student
        System.out.println(clazz.getSuperclass()); // class java.lang.Object
        System.out.println(clazz.getInterfaces()); // [Ljava.lang.Class;@7f31245a
        System.out.println(clazz.getPackage()); // package enity
        System.out.println(clazz.getProtectionDomain());
        System.out.println(clazz.getResource("Student.class")); // file:/D:/workspaces/java-base/target/classes/enity/Student.class
        // 可以通过构造函数实例化
        Constructor cons = clazz.getDeclaredConstructor();
        Object obj = cons.newInstance();
        System.out.println(obj);
    }
}
