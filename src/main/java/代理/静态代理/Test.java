package 代理.静态代理;

import 代理.User;
import 代理.UserImpl;

public class Test {
    public static void main(String[] args) {
        //目标对象
        User user = new UserImpl();
        //代理对象
        User userProxy = new ProxyUser(user);
        userProxy.save("student");
    }
}
