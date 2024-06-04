package 基础.浅深拷贝;

import enity.Student;
import enity.StudentClone;
import org.apache.commons.lang3.SerializationUtils;

import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        /**
         * 常见的深拷贝方式
         * 1.构造函数方式（new的方式）
         * 2.重写clone方法
         * 3.Apache Commons Lang序列化
         * 4.Gson序列化
         * 5.Jackson序列化
         */
//        serializationUtilsShenCopy();
//        qianCopy();
        cloneShenCopy();
    }

    private static void cloneShenCopy() {
        List<StudentClone> list1 = new ArrayList<>();
        StudentClone user1 = new StudentClone();
        user1.setName("张三");
        StudentClone user2 = new StudentClone();
        user2.setName("李四");
        list1.add(user1);
        list1.add(user2);
        //通过clone方式，把list01拷贝给list02
        List<StudentClone> list2 = new ArrayList<>();
        //TODO 当数据量多时，建议使用对象的方式，把List当做属性，然后拷贝哦到一个新的对象中，从而不需要循环，可以见Apache Commons Lang序列化深拷贝方式
        for (StudentClone user : list1) {
            try {
                list2.add(user.clone());
            } catch (CloneNotSupportedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("list1未改变前，list2的结果为：" + list2);

        //改变list1集合中的user1对象
        System.out.println("--------------------------------------------");
        user1.setName("老六");

        System.out.println("list1改变后，list2的结果为：" + list2);
    }

    private static void serializationUtilsShenCopy() {
        List<Student> list1 = new ArrayList<>();
        Student user1 = new Student();
        user1.setName("张三");
        Student user2 = new Student();
        user2.setName("李四");
        list1.add(user1);
        list1.add(user2);

        //使用UserCopyDTO对象，专门用于拷贝List<User>类型数据，不需要再去遍历list1
        UserCopyDTO userCopyDTO = new UserCopyDTO();
        userCopyDTO.setUsers(list1);
        //通过Apache Commons Lang序列化方式，把list01拷贝给list02
        UserCopyDTO clone = SerializationUtils.clone(userCopyDTO);
        List<Student> list2 = clone.getUsers();
        System.out.println("list1未改变前，list2的结果为：" + list2);

        //改变list1集合中的user1对象
        System.out.println("--------------------------------------------");
        user1.setName("老六");
        System.out.println("list1改变后，list2的结果为：" + list2);
    }

    private static void qianCopy() {
        List<Student> list1 = new ArrayList<>();
        Student user1 = new Student();
        user1.setName("张三");
        Student user2 = new Student();
        user2.setName("李四");
        list1.add(user1);
        list1.add(user2);
        //TODO 以下是开发中，经常发生的浅拷贝
        //方式1：通过new ArrayList方式，把list01拷贝给list02
        List<Student> list2 = new ArrayList<>(list1);
        System.out.println("list1未改变前，list2的结果为：" + list2);
        //改变list1集合中的user1对象
        System.out.println("--------------------------------------------");
        user1.setName("老六");

        System.out.println("list1改变后，list2的结果为：" + list2);
    }

    /**
     * List<String> 的深拷贝（但本质上依然是浅拷贝）
     */
    private static void strListCopy() {
        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        List<String> list1 = new ArrayList<>(list);
        System.out.println(list.subList(0, 2)); //

        list.subList(0, 2).clear();
        System.out.println(list);
        System.out.println(list1); // [3, 4]
    }
}
