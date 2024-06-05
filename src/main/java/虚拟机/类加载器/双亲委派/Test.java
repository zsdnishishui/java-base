package 虚拟机.类加载器.双亲委派;

import enity.Student;
import sun.util.cldr.CLDRLocaleDataMetaInfo;

import java.net.URL;
import java.security.Provider;

public class Test {
    public static void main(String[] args) {
        System.out.println("**********启动类(引导类)加载器**************");
        //获取BootstrapClassLoader能够加载的api的路径
        URL[] urLs = sun.misc.Launcher.getBootstrapClassPath().getURLs();
        for (URL element : urLs) {
            System.out.println(element.toExternalForm());
        }
        //从上面的路径中随意选择一个类,来看看他的类加载器是什么:引导类加载器
        ClassLoader classLoader = Provider.class.getClassLoader();
        System.out.println(classLoader); // null 由于启动类加载器无法被Java程序直接引用，因此JVM默认直接使用 null 代表启动类加载器

        System.out.println("***********扩展类加载器*************");
        String extDirs = System.getProperty("java.ext.dirs");
        for (String path : extDirs.split(";")) {
            System.out.println(path);
        }
        //从上面的路径中随意选择一个类,来看看他的类加载器是什么:扩展类加载器
        ClassLoader classLoader1 = CLDRLocaleDataMetaInfo.class.getClassLoader();
        System.out.println(classLoader1);//sun.misc.Launcher$ExtClassLoader@1540e19d

        System.out.println("***********应用程序类加载器*************");
        System.out.println(Student.class.getClassLoader()); //sun.misc.Launcher$AppClassLoader@18b4aac2
    }
}
