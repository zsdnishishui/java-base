package 代理.动态代理.cglib动态代理;

import enity.Student;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * cglib是基于修改字节码技术实现的
 */
public class Test {
    public static void main(String[] args) {
        //目标对象
        Student user = new Student();
        //工具类
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(Student.class);
        enhancer.setCallback(new MethodInterceptor() {
            @Override
            public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                System.out.println("cglib动态代理");
                method.invoke(user, objects);
                return null;
            }
        });
        //代理对象
        Student userProxy = (Student) enhancer.create();
        userProxy.setId("student");
    }
}
