package 虚拟机.类加载器;

public class Test {
    public static void main(String[] args) {
        /**
         * https://blog.csdn.net/Leon_Jinhai_Sun/article/details/106462771
         */
        Thread t2 = new Thread();
        //输出：sun.misc.Launcher$AppClassLoader@43be2d65 新线程没有设置ContextClassLoader，将继承其父线程的上下文类加载器
        System.out.println(t2.getContextClassLoader());

        //输出：null 因为Thread.class 是引导类加载加载的，所以其父类加载器 是为空
        System.out.println(t2.getClass().getClassLoader());

        ClassLoader loader = Thread.currentThread().getContextClassLoader();
        System.out.println(loader); // sun.misc.Launcher$AppClassLoader@18b4aac2
        System.out.println(loader.getParent()); // sun.misc.Launcher$ExtClassLoader@7f31245a
        System.out.println(loader.getParent().getParent()); // null
    }
}
