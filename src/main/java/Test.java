import enity.Student;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Test {
    /**
     * @param string
     * @return 转换之后的内容
     * @Title: unicodeDecode
     * @Description: unicode解码 将Unicode的编码转换为中文
     */
    public static  String unicodeDecode(String string) {
        Pattern pattern = Pattern.compile("(\\\\u(\\p{XDigit}{4}))");
        Matcher matcher = pattern.matcher(string);
        char ch;
        while (matcher.find()) {
            ch = (char) Integer.parseInt(matcher.group(2), 16);
            string = string.replace(matcher.group(1), ch + "");
        }
        return string;
    }
    private static String getPercent(int x, int y) {
        double d1 = x * 1.0;
        double d2 = y * 1.0;
        // 设置保留几位小数， “.”后面几个零就保留几位小数，这里设置保留2位小数
        DecimalFormat decimalFormat = new DecimalFormat("#0.00");
        return decimalFormat.format(0.787401575);
    }
    public static void main(String[] args) {
//46+33+23+10+8+6+1
        System.out.println(getPercent(1,127));
        BigDecimal a = new BigDecimal("100");
        BigDecimal b = new BigDecimal("100.0");
        System.out.println(Objects.equals(a.doubleValue(), 100.0)); // true
        System.out.println(a.compareTo(b));
        double d = 5.0/10;
        System.out.println(d);
        System.out.println(unicodeDecode("\\u8054\\u901a"));
        StringBuffer sb = new StringBuffer();
        System.out.println(sb.toString());
        List<Student> studentList = new ArrayList<>();
        Student student1 = new Student();
        student1.setId("1");
        student1.setName("张三");

        Student student2 = new Student();
        student2.setId("2");
        student2.setName("李四");

        Student student3 = new Student();
        student3.setId("3");
        student3.setName("王五");
        studentList.add(student1);
        studentList.add(student2);
        studentList.add(student3);
        for (Student student : studentList) {
            System.out.println(student.getId());
            try {
//                try {
//                    int b = 2/0;
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }

//                int i = 2/0;
            } catch (Exception e){
                e.printStackTrace();
            }


        }

        List<Map<String, String>> listMap = new ArrayList<>();
        Map<String, String> m1 = new HashMap();
        m1.put("name", "王五");
        Map<String, String> m2 = new HashMap();
        m2.put("name", "王五");
        listMap.add(m1);
        listMap.add(m2);
        List<String> list = studentList.stream().filter(f -> listMap.stream().map(map -> map.get("name")).collect(Collectors.toList()).contains(f.getName())).map(m -> m.getName()).collect(Collectors.toList());
        List<Student> students = list.stream().map(Student::new).collect(Collectors.toList());
        System.out.println(students);
    }
}
