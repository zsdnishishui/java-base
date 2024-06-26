package 函数式编程;

import java.util.function.IntSupplier;
import java.util.stream.IntStream;

public class IntStreamTest {
    public static void main(String[] args) {

        IntStream natual = IntStream.generate(new IntNatualSupplier());
        // 注意：无限序列必须先变成有限序列再打印
        natual.limit(10).forEach(IntStreamTest::print);
    }

    public static void print(Integer o) {
        System.out.println(o);

    }
}


class IntNatualSupplier implements IntSupplier {
    int n = 0;

    /**
     * Gets a result.
     *
     * @return a result
     */
    @Override
    public int getAsInt() {
        n++;
        return n;
    }
}