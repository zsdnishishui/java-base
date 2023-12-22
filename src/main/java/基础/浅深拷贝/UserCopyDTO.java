package 基础.浅深拷贝;

import enity.Student;

import java.io.Serializable;
import java.util.List;

public class UserCopyDTO implements Serializable {//必须实现Serializable接口
    private List<Student> users;

    public List<Student> getUsers() {
        return users;
    }

    public void setUsers(List<Student> users) {
        this.users = users;
    }
}
