package 代理;

public class UserImpl implements User {
    @Override
    public void save(String  student) {
        System.out.println("保存数据"+student);
    }
}
