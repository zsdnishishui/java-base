package 函数式编程;

import java.util.function.LongSupplier;
import java.util.stream.LongStream;

public class LongStreamTest {
    public static void main(String[] args) {

        LongStream natual = LongStream.generate(new LongNatualSupplier());
        // 注意：无线序列必须先变成有限序列再打印
        natual.limit(10).forEach(System.out::println);
    }
}


class LongNatualSupplier implements LongSupplier {
    int a = 1;
    int b = 1;
    /**
     * Gets a result.
     *
     * @return a result
     */
    @Override
    public long getAsLong() {
        int temp = a + b;
        a = b;
        b = temp;
        return temp;
    }
}