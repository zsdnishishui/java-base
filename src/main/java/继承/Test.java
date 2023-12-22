package 继承;

public class Test {
    public static void main(String[] args) {

        B b = new B();
        System.out.println(b.num(3, 4));
        System.out.println(b.add(3, 4));
        A a = new A();
        System.out.println(a.add(1,2));
        // 向上转型,使用的是B重写的方法
        A aa = new B();
        aa.setId("opo");
        System.out.println(aa.add(1,2));
        System.out.println(aa.getId());

        Object obj = "hello";
        if (obj instanceof String) {
            String s = (String) obj;
            System.out.println(s.toUpperCase());
        }
    }
}
