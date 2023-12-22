package 函数式编程;

import java.util.function.Supplier;
import java.util.stream.Stream;

public class StringTest {
    public static void main(String[] args) {

        Stream<String> natual = Stream.generate(new StringSupplier());
        // 注意：无线序列必须先变成有限序列再打印
        natual.limit(15).forEach(System.out::println);
    }

}

class StringSupplier implements Supplier<String> {
    int a = 1;
    int b = 1;
    /**
     * Gets a result.
     *
     * @return a result
     */
    @Override
    public String get() {
        String temp = a + "," +b;
        a = a + b;
        b = a + b;
        return temp;
    }
}