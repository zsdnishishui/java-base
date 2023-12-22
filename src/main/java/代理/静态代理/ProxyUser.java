package 代理.静态代理;

import 代理.User;

public class ProxyUser  implements User {
    private User target;

    public ProxyUser(User target) {
        this.target = target;
    }

    @Override
    public void save(String student) {
        System.out.println("静态代理");
        target.save(student);
    }
}
