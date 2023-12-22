package 代理.动态代理.jdk动态代理;

import 代理.User;
import 代理.UserImpl;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * jdk动态代理是基于字节码生成技术
 */
public class Test {
    public static void main(String[] args) {
        //目标对象
        User user = new UserImpl();
        //代理对象
        User userProxy = (User) Proxy.newProxyInstance(User.class.getClassLoader(), new Class[]{User.class}, new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println("jdk动态代理");
                method.invoke(user, args);//这里可以弄一个代理工厂类
                return null;
            }
        });
        userProxy.save("student");
    }
}
