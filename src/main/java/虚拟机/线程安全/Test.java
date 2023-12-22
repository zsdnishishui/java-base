package 虚拟机.线程安全;

import java.util.concurrent.atomic.AtomicInteger;

public class Test {
    // volatile只能保证可见性，并不保证原子性。
    public static volatile int a = 0;

    public static AtomicInteger b = new AtomicInteger(0);

    public static void increase() {
        // a++ 不是原子操作
        a++;
        // b是利用CAS来实现原子操作
        b.incrementAndGet();
    }

    public static void main(String[] args) {
        for (int i = 0; i < 20; i++) {
            new Thread(() -> {
                for (int j = 0; j < 10000; j++) {
                    increase();
                }
            }).start();
        }
        while (Thread.activeCount() > 2) ;
        System.out.println("a最终结果：" + a);
        System.out.println("b最终结果：" + b);
    }

}
