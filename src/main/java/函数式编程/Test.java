package 函数式编程;

import java.util.function.Supplier;
import java.util.stream.Stream;

public class Test {
    public static void main(String[] args) {

        Stream<Integer> natual = Stream.generate(new NatualSupplier());
        // 注意：无线序列必须先变成有限序列再打印
        natual.limit(10).forEach(System.out::println);
    }

}

class NatualSupplier implements Supplier<Integer> {
    int n = 0;
    @Override
    public Integer get(){
        n++;
        return n;
    }
}