package 虚拟机.字符串常量;

public class Test {
    public static void main(String[] args) {
        String str1 = new StringBuilder("计算机").append("软件").toString();

        String str2 = new StringBuilder("Ja").append("va").toString();

        String str3 = "java";
        String str4 = new String("java");

        System.out.println(str1.intern() == str1);//因为之前没有所以创建的引用和intern()返回的引用相同

        System.out.println(str2.intern() == str2);//"java在StringBuilder()之前已经出现过",所以intern()返回的引用与新创建的引用不是同一个

        System.out.println(str3.intern() == str4.intern());

        String a = new String("abc") + new String("def");
//        a.intern();
        String b = "abcdef";
//        a.intern();
        System.out.println(a == b);

    }
}
