package 基础;

import 继承.B;

import java.math.BigDecimal;
import java.util.Objects;

public class BigDecimalTest {
    public static void main(String[] args) {
        BigDecimal a = new BigDecimal("100");
        BigDecimal b = new BigDecimal("100.0");
        System.out.println(Objects.equals(a.doubleValue(), 100.0));
        System.out.println(a.compareTo(b));
    }
}
